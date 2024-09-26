public class Temp2405 {
    public static void main(String[] args) {
        Temp2405 temp = new Temp2405();
        try {
            temp.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String... args) throws Exception {
        // Assuming these repos are already initialized
        MeccanicoRepository meccanicoRepo = new MeccanicoRepository();
        InterventoRepository interventoRepo = new InterventoRepository();

        // Create a Meccanico entity
        Meccanico meccanico = new Meccanico();
        // Set its properties

        // Save the Meccanico
        meccanicoRepo.save(meccanico);

        // Now create an Intervento and set its associated Meccanico
        Intervento intervento = new Intervento();
        // Set other properties

        // Associate the saved meccanico
        intervento.setMeccanico(meccanico);

        // Save the Intervento
        interventoRepo.save(intervento);
    }
}

// Dummy classes for the sake of completeness
class Meccanico {
    // Meccanico properties and methods
}

class Intervento {
    private Meccanico meccanico;
    // Other properties and methods

    public void setMeccanico(Meccanico meccanico) {
        this.meccanico = meccanico;
    }
}

class MeccanicoRepository {
    public void save(Meccanico meccanico) {
        // Save logic
    }
}

class InterventoRepository {
    public void save(Intervento intervento) {
        // Save logic
    }
}