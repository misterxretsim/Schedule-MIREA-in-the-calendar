package ru.gosha.SG_Muwa;
import ru.gosha.InputSeeker;

public class SeekerType {
    private String teacher;
    private String studyGroup;

    /**
     * Миша, я переделал перечесления на класс, так как мне удобнее так, если не надо было - скажи
     * @param teacher Учитель:)
     * @param studyGroup Группа:)
     */

    public SeekerType(String teacher, String studyGroup){
        this.teacher = teacher;
        this.studyGroup = studyGroup;
    }

    public String getTeacher(){
        return teacher;
    }

    public String getStudyGroup(){
        return studyGroup;
    }

}
