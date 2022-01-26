import com.example.gestion_employer1.hibernate.HSessionFactory;

public class Main {
    public static void main (String[] args){
        HSessionFactory.getInstance().getSession().openSession();
    }
}
