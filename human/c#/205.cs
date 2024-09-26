csharp
using System;

public enum documentEnum
{
    public enum docType
    {
        text,
        image
    }

    public enum docStatus
    {
        Editable,
        ReadOnly
    }
}

public enum userEnum
{
    public enum Status
    {
        SuperUser,
        NormalUser
    }
}

public class Document
{
    public int docTypeId { get; set; }
    public int CreatedByUserId { get; set; }
    public int statusId { get; set; }
}

public class User
{
    public int UserID { get; set; }
    public userEnum.Status UserStatus { get; set; }
}

public class DocumentPermissions
{
    private Document document;
    private User user;

    public DocumentPermissions(Document doc, User currentUser)
    {
        document = doc;
        user = currentUser;
    }

    public bool ShouldShowEditButton()
    {
        if(!IsTextDocument())
        {
            return false;
        }
        return IsSuperUser() || IsDocumentOwner() ||  DocumentIsEditable();
    }

    private bool IsTextDocument()
    {
        return document.docTypeId == (int)documentEnum.docType.text;
    }

    private bool IsSuperUser()
    {
        return user.UserStatus == userEnum.Status.SuperUser;
    }

    private bool IsDocumentOwner()
    {
        return user.UserID == document.CreatedByUserId ;
    }

    private bool DocumentIsEditable()
    {
        return document.statusId == (int)documentEnum.docStatus.Editable ;
    }
}

public class Program
{
    public static void Main()
    {
        var document = new Document { docTypeId = (int)documentEnum.docType.text, CreatedByUserId = 1, statusId = (int)documentEnum.docStatus.Editable };
        var user = new User { UserID = 1, UserStatus = userEnum.Status.SuperUser };

        var documentPermissions = new DocumentPermissions(document, user);
        Console.WriteLine(documentPermissions.ShouldShowEditButton());
    }
}