package bt4;

class Student {
    private String name;
    private String classes;

    public String getName() {
        return name;
    }

    public String getClasses() {
        return classes;
    }

    public Student() {
        this.name = "John";
        this.classes = "C02";
    }

    // Public method to set the name
    public void setName(String name) {
        this.name = name;
    }
    public void setClasses(String classes) {
        this.classes = classes;
    }
}
