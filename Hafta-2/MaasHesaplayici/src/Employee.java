public class Employee {
    String name;
    double salary;
    int workHour;
    int hireYear;

    public Employee(String name, int salary, int workHour, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHour = workHour;
        this.hireYear = hireYear;


    }

    public double tax() {
        if (salary > 1000) {
            return salary * 0.03;
        }
        return 0.0;
    }

    public double bonus() {
        int bonusRate = 30;
        int extraHours = workHour - 40;
        if (extraHours > 0) {
            return bonusRate * extraHours;
        }
        return 0.0;
    }

    public double raiseSalary() {
        int currentYear = 2021;
        int yearsWorked = currentYear - hireYear;

        double raise = 0.0;

        if (yearsWorked < 10) {
            raise = salary * 0.05;
        } else if (yearsWorked < 20) {
            raise = salary * 0.10;
        } else {
            raise = salary * 0.15;
        }

        return raise;
    }

    public void print() {
        System.out.println("=========================");
        System.out.println("Çalışan ismi : " + this.name);
        System.out.println("Maaşı : " + this.salary);
        System.out.println("Çalışma saati : " + this.workHour);
        System.out.println("Başlangıç yılı : " + this.hireYear);
        System.out.println("Vergi : " + tax());
        System.out.println("Bonus : " + bonus());
        System.out.println("Maaş artışı : " + raiseSalary());
        System.out.println("Vergi ve Bonuslar ile birlikte maaş : " + +(this.salary + bonus() - tax()));
        System.out.println("Toplam Maaş : " + (this.salary + raiseSalary()));
    }


}





