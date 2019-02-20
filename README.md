Id - bardzo ważna rzecz w tabelach baz danych. Służy jako identyfikator rzędu.

W Hibernate:

@Id - adnotacja naznaczająca kolumnę jako PRIMARY KEY w tabeli.
@GeneratedValue - adnotacja służąca do generowanie wartości id. Domyślnie jest to strategia, która automatycznie zwiększa wartość. czyli @GeneratedValue(strategy = GenerationType.AUTO) 

Enum GenerationType posiada 4 wartości: AUTO, TABLE, SEQUENCE, IDENTITY.

Sekwencja to obiekt bazy danych, który generuje przyrostowe liczby całkowite dla każdego kolejnego żądania. Zalety sekwencji:

- sekwencja jest wolna od tabel, tę samą sekwencję mozna przypisać do wielu kolumn lub tabel

- sekwencja może wstępnie przydzielać wartości, aby poprawić wydajność


Jak stworzyć przykładową sekwencję:

@Entity(name = "sequenceIdentifier) {
public class SequenceIdentifier {
	@Id
	@GenericGenerator(
		name = "sequence"
		strategy = "sequence"
		parameters = {
			@org.hibernate.annotations.Parameter(
				name = "sequence:,
				value = "sequence"
			)
	})
	@GeneratedValue(generator = "sequence")
	private Long id;
}
