package como.exampleo.firebaseo;

public class Cada_dia {

    public int numero;
    public String hora_descanso;
    public String hora_reloj;
    public String asignatura;

    public Cada_dia(int numero, String hora_descanso, String hora_reloj, String asignatura) {
        this.numero = numero;
        this.hora_descanso = hora_descanso;
        this.hora_reloj = hora_reloj;
        this.asignatura = asignatura;
    }

    public int getNumero() {
        return numero;
    }

    public String getHora_descanso() {
        return hora_descanso;
    }

    public String getHora_reloj() {
        return hora_reloj;
    }

    public void setHora_descanso(String hora_descanso) {
        this.hora_descanso = hora_descanso;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setHora_reloj(String hora_reloj) {
        this.hora_reloj = hora_reloj;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
