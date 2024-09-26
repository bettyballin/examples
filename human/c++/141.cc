cpp
#include <ntifs.h>
#include <wdf.h>

// Global variables
PDRIVER_OBJECT g_DriverObject;
POOL_TYPE NonPagedPool = NonPagedPoolNx;

// asm routines: call corresponding *Routine and jmp ObfDereferenceObject for g_DriverObject
VOID CALLBACK RundownRoutine(PKAPC Apc)
{
    _RundownRoutine(Apc);
}

VOID CALLBACK KernelRoutine(PKAPC Apc, PKNORMAL_ROUTINE *NormalRoutine, PVOID *NormalContext, PVOID *SystemArgument1, PVOID *SystemArgument2)
{
    _KernelRoutine(Apc, NormalRoutine, NormalContext, SystemArgument1, SystemArgument2);
}

VOID CALLBACK NormalRoutine(PVOID NormalContext, PVOID SystemArgument1, PVOID SystemArgument2)
{
    _NormalRoutine(NormalContext, (PEPROCESS)SystemArgument1, (PFILE_OBJECT)SystemArgument2);
}

VOID CALLBACK _NormalRoutine(
    PVOID NormalContext,
    PEPROCESS Process,
    PFILE_OBJECT FileObject
)
{
    __pragma(message("extern " __FUNCDNAME__ " : PROC ; "  __FUNCSIG__))

    DbgPrint("NormalRoutine(%p, %p %s)\n", Process, FileObject, PsGetProcessImageFileName(Process));

    if (NeedTerminate(Process, FileObject))
    {
        HANDLE hProcess;
        if (0 <= ObOpenObjectByPointer(Process, 0, 0, PROCESS_TERMINATE, *PsProcessType, KernelMode, &hProcess))
        {
            status = ZwTerminateProcess(hProcess, STATUS_ACCESS_DENIED);
            ZwClose(hProcess);
        }
    }

    ObfDereferenceObject(FileObject);
    ObfDereferenceObject(Process);
}

VOID CALLBACK _RundownRoutine(PKAPC Apc)
{
    __pragma(message("extern " __FUNCDNAME__ " : PROC ; "  __FUNCSIG__))

    DbgPrint("--Apc<%p>\n", Apc);
    delete Apc;
}

VOID CALLBACK _KernelRoutine(
    PKAPC Apc,
    PKNORMAL_ROUTINE * /*NormalRoutine*/,
    PVOID * /*NormalContext*/,
    PVOID * /*SystemArgument1*/,
    PVOID * /*SystemArgument2*/
)
{
    __pragma(message("extern " __FUNCDNAME__ " : PROC ; "  __FUNCSIG__))

    DbgPrint("KernelRoutine<%p>\n", Apc);

    ObfReferenceObject(g_DriverObject);//NormalRoutine will be called

    _RundownRoutine(Apc);
}

void CreateProcessNotifyRoutineEx(PEPROCESS Process, HANDLE ProcessId, PPS_CREATE_NOTIFY_INFO CreateInfo)
{
    PFILE_OBJECT FileObject;

    if (CreateInfo && !CreateInfo->IsSubsystemProcess && (PFILE_OBJECT FileObject = CreateInfo->FileObject))
    {
        // for do main job out of critical region
        if (PKAPC Apc = new(NonPagedPool) KAPC)
        {
            KeInitializeApc(Apc, KeGetCurrentThread(), OriginalApcEnvironment, KernelRoutine, RundownRoutine, NormalRoutine, KernelMode, 0);

            DbgPrint("++Apc<%p> \n", Apc);

            ObfReferenceObject(g_DriverObject);
            ObfReferenceObject(Process);
            ObfReferenceObject(FileObject);

            if (!KeInsertQueueApc(Apc, Process, FileObject, IO_NO_INCREMENT))
            {
                ObfDereferenceObject(FileObject);
                ObfDereferenceObject(Process);
                ObfDereferenceObject(g_DriverObject);
                delete Apc;
            }
        }
    }
}

void* __cdecl operator new(size_t size, POOL_TYPE PoolType)
{
    return ExAllocatePool(PoolType, size);
}

void __cdecl operator delete(PVOID pv)
{
    ExFreePool(pv);
}

NTSTATUS DriverEntry(PDRIVER_OBJECT DriverObject, PUNICODE_STRING RegistryPath)
{
    g_DriverObject = DriverObject;
    // Register CreateProcessNotifyRoutineEx
    PsSetCreateProcessNotifyRoutineEx((PCREATE_PROCESS_NOTIFY_ROUTINE_EX)CreateProcessNotifyRoutineEx, FALSE);
    return STATUS_SUCCESS;
}