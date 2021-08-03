package demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EngineeringStudent extends Student {

    private int eid;

    public EngineeringStudent(int id, int eid, String name) {
        super(id, name);
        this.eid = eid;
    }

    @Override
    public String toString() {
        return "[id=" + super.getId() + ",name=" + super.getName() + ",eid=" + eid + "]";
    }
}
