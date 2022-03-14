package hibernateBasic.day8;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StudentMarks {
    private int id;
    private List<Integer> marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarks() {
        String [] str = new String[marks.size()];
        for (int i=0;i<marks.size();i++){
            str[i]=marks.get(i).toString();
        }

        return String.join(",", str);
    }

    public void setMarks(String _marks) {
        String[] marksarray= _marks.split(",");
        marks=new ArrayList<>();
        for (String s:marksarray){
            marks.add(parseInt(s));
        }
    }
    @Override
    public String toString() {
        return "StudentMarks{" +
                "id=" + id +
                ", marks=" + marks +
                '}';
    }
}
