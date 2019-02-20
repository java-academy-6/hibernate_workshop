package pl.kk;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.kk.baza.Adres;
import pl.kk.baza.Osoba;
import pl.kk.baza.Umowa;

import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class LadowanieGorliweLeniwe {

    /**
     * Pobawcie się z wyświetlaniem danych z bazy. Włączone jest wyświetlanie zapytań - popatrzcie, jakie dane są zaciągane i kiedy.
     * 1. Co się stanie, gdy w klasach ORM zmienimy FetchType na EAGER?
     * 2. Zmieńcie parametr drukujTezAdresy w metodzie drukujUmowyOsoby na false. Ile wtedy jest zapytań i przy jakich ustawieniach?
     * 3. Zakomentujcie całkiem drukowanie umów, zostawiając tylko listowanie osób. Co wtedy się dzieje?
     * 4. Co zrobić, by liczba zapytań była mniejsza?
     */
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            przygotujBaze(sessionFactory);
            dajOdpoczac();
            wyswietlanieDanychZBazy(sessionFactory);
        }
    }

    private static void wyswietlanieDanychZBazy(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            System.out.println("*** Pobieranie danych z bazy: ***");
            List<Osoba> osoby = session.createQuery("FROM Osoba", Osoba.class).list();
            dajOdpoczac();
            System.out.println("Lista osób w bazie:");
            osoby.forEach(osoba -> {
                drukujImieOsoby(osoba);
                drukujUmowyOsoby(osoba, true);
                System.out.println("--- Koniec osoby ---");
            });
        }
    }

    private static void drukujUmowyOsoby(Osoba x, boolean drukujTezAdresy) {
        x.getUmowas().forEach(umowa -> {
            System.out.println(umowa.getNazwa());
            if (drukujTezAdresy) {
                System.out.println("Adresy: " + umowa.getAdresy());
            }
        });
    }

    private static void drukujImieOsoby(Osoba x) {
        System.out.println("Osoba: " + x.getImie());
    }

    private static void dajOdpoczac() {
        System.out.println("==============");
        System.out.println("Teraz chwila oddechu... :)");
        System.out.println("==============");
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Przeszkodzono wątkowi!");
            Thread.currentThread().interrupt();
        }
    }

    private static void przygotujBaze(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            Osoba janek = new Osoba("Janek");
            Osoba kurek = new Osoba("Kurek");
            Adres adres1 = new Adres("Kraków", "Opolska", 110);
            Adres adres2 = new Adres("Kraków", "Czerwone Maki", 1);
            Umowa u1 = new Umowa("Umowa Janka");
            Set<Adres> adresy = Set.of(adres1, adres2);
            u1.setAdresy(adresy);
            Umowa u2 = new Umowa("Druga Umowa Janka");
            u2.setAdresy(adresy);
            Umowa u3 = new Umowa("Trzecia Umowa Janka");
            Umowa u4 = new Umowa("Czwarta Umowa Janka");
            Umowa u5 = new Umowa("Umowa Kurka");
            Umowa u6 = new Umowa("Druga Umowa Kurka");
            Set<Umowa> umowyJanka = Set.of(u1, u2, u3, u4);
            Set<Umowa> umowyKurka = Set.of(u5, u6);
            janek.setUmowas(umowyJanka);
            kurek.setUmowas(umowyKurka);

            session.beginTransaction();
            adresy.forEach(session::persist);
            umowyJanka.forEach(session::persist);
            umowyKurka.forEach(session::persist);
            session.persist(janek);
            session.persist(kurek);
            session.getTransaction().commit();
        }
    }
}
