/*
 *     DuyDuc94
 */
package model;

public class Brand {

    private int ID;
    private String Name;

    public Brand() {
    }

    public Brand(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Brand{");
        sb.append("ID=").append(ID);
        sb.append(", Name=").append(Name);
        sb.append('}');
        return sb.toString();
    }

}
