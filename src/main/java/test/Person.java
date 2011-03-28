
import java.util.List;
import java.util.ArrayList;

public class Person{
    private String navn;
    private String etternavn;
    private Integer alder;

    public Person(String fornavn, String etternavn, Integer alder){
        this.navn = fornavn;
        this.etternavn = etternavn;
        this.alder = alder;
    }

    public String fulltNavn(){
        return navn + " " + etternavn;
    }

    public List<String> interesse(String starterMed){
        List<String> interesser = new ArrayList<String>();
        interesser.add("Gym");
        interesser.add("Sykkel");
        interesser.add("Scala");
        interesser.add("Vask");
        interesser.add("Mat");

        List<String> valgte = new ArrayList<String>();
        for(String interesse : interesser){
            if(interesse.startsWith(starterMed)){
                valgte.add(interesse);
            }
        }

        return valgte;
    }

    public String getNavn(){ return navn; }
    public void setNavn(String navn){ this.navn = navn; }

    public String getEtternavn(){ return etternavn; }
    public void setEtternavn(String etternavn){ this.etternavn = etternavn; }

    public Integer getAlder(){ return alder; }
    public void setAlder(Integer alder){ this.alder = alder; }
}


