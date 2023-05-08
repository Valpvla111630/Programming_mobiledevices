package application2email.co;

public class Emails {
    private int id;
    private String name;
    private String subject;
    private String remitente;
    private String date;
    private String foto;

    public Emails(int id, String name, String subject, String remitente, String date, String foto) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.remitente = remitente;
        this.date = date;
        this.foto = foto;
    }


    public Emails(int id) {
        this.id = id;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getsubject() {
        return subject;
    }

    public void setsubject(String subject) {
        subject = subject;
    }

    public String getremitente() {
        return remitente;
    }

    public void setremitente(String remitente) {
        remitente = remitente;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        date = date;
    }

    public String getfoto() {
        return foto;
    }

    public void setFoto(String foto) {
        foto = foto;
    }

    @Override
    public String toString() {
        return "Emails{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Subject='" + subject + '\'' +
                ", Remitente='" + remitente + '\'' +
                ", Date='" + date + '\'' +
                ", Foto='" + foto + '\'' +
                '}';
    }
}

