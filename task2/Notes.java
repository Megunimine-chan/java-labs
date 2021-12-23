package task2;

import java.util.ArrayList;
import java.util.List;

public class Notes {

    private List<CuratorRegisterNote> notes;

    public Notes() {
        this.notes = new ArrayList<>();
    }

    public void addNote(CuratorRegisterNote note){
        notes.add(note);
    }

    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        for (CuratorRegisterNote i : notes) {
            data.append(i.toString());
        }
        return data.toString();
    }
}
