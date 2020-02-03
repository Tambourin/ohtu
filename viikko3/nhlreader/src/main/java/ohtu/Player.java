
package ohtu;

public class Player {
    private String name;
    private String team;
    private String nationality;
    private Integer goals;
    private Integer assists;
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }
    public Integer getPoints() {
        return goals + assists;
    } 

    @Override
    public String toString() {
        return name + " " + team + " " + nationality + " goals: " + goals + " assists:" + assists;
    }
      
}
