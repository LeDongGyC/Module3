package bean;

public class HinhThuc {
    private int idType;
    private String nameType;

    public HinhThuc() {
    }

    public HinhThuc(int idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public HinhThuc(int idType) {
        this.idType = idType;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
