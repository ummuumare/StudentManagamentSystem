import java.util.List;
import java.util.Scanner;

//3-Student ile ilgili methodlar icin StudentService classi olusturuldu
public class StudentService {
    // 9-reponun methodlarini kullnmak icin obje olustur
    Scanner inp = new Scanner(System.in);
    StudentRepository repository = new StudentRepository();

    //10-Tablo olusturmak icin method
    public void createTable() {
        repository.createTable();
    }

    //11-Öğrenci kaydetme
    public void saveStudent() {
        System.out.println("Ad : ");
        String name = inp.nextLine().trim();
        System.out.println("Soyad : ");
        String lastname = inp.nextLine().trim();
        System.out.println("Şehir : ");
        String city = inp.nextLine().trim();
        System.out.println("Yaş : ");
        int age = inp.nextInt();
        inp.nextLine();
        Student newStudent = new Student(name, lastname, city, age);
        repository.save(newStudent);

    }

    //13-Ogrenciler Listele
    public void getAllStudents() {
        repository.findAll();
    }

    //15- OGRENCI SILME
    public void deleteStudent(int id) {
        repository.delete(id);
    }


    //17-id ile ogrenci bulma(getirme)
    public Student getStudentById(int id) {
        Student student = repository.findStudentById(id);
        return student;
    }

    //19- ogrenciyi guncelleme
    public void updateStudent(int id) {
        Student student = getStudentById(id);
        if (student == null) {
            System.out.println("ogrenci bulunamadi");
        } else {
            System.out.println("Ad : ");
            String name = inp.nextLine().trim();
            System.out.println("Soyad : ");
            String lastname = inp.nextLine().trim();
            System.out.println("Şehir : ");
            String city = inp.nextLine().trim();
            System.out.println("Yaş : ");
            int age = inp.nextInt();
            inp.nextLine();

            //yeni degerlerle fieldlari guncelle
            student.setName(name);
            student.setCity(city);
            student.setLastName(lastname);
            student.setAge(age);
            repository.update(student);


        }
    }

            //21-girilen kelime ad veya soyad da var olan student lari listele
            //kelime ay oldugunda ==> ad veya soy adda ay icerenler gelecek
    public void listStudentByNameOrLastName(){
        System.out.println("Ad veya soyad");
        String nameOrSurname = inp.nextLine();

        //birden fazla kayit donebilir
        List<Student> studentList =repository.findStudentByNameORLastName(nameOrSurname);
        //listedeki ogrencileri yazdiralim
        //list bos ise
        if (studentList.size()==0){
            System.out.println("ogrenci bulunamadi");
        } else {
               studentList.forEach(System.out::println);
        }

    }
}