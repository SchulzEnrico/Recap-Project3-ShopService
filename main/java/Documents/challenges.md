# Shop Service (Advanced)

## Unklarheiten beseitigen

Welche Fragen sind aus den vorherigen Sessions offen geblieben?
Bitte klärt diese Fragen als Gruppe.
Nutzt zur Klärung alle verfügbaren Ressourcen.

Wenn ihr bereit seid, klickt auf 'Weiter'

## Coding: ShopService

Heute dreht sich alles um die ShopService Aufgabe. Ergänzt oder schreibt für alle Schritte in der Aufgabe Tests, außer es ist anders angegeben.

Klont Euch die Musterlösung: [ShopService](https://github.com/Flooooooooooorian/Recap-Project-Objektorientierung-ShopService). Ihr arbeitet heute in neuen Gruppenkonstellationen und sollt Erfahrung im Arbeiten mit fremden Code sammeln. Deshalb arbeitet bitte heute auf Basis der Musterlösung aus dem letzten Modul.

Nun entfernt die Verknüpfung zu Florians Github-Repository, in dem Ihr im Menü unter "Git" "Manage Remotes" auswählt und dort den Eintrag "origin" entfernt.

Ladet das Projekt als neues Repository auf GitHub in einen von Euren eigenen GitHub-Accounts hoch: In IntelliJ wählt bei dem geklonten Projekt im Menü "Git", unter "GitHub", "Share Project on GitHub" aus.

Die Musterlösung ist nun der main-Branch Eures GitHub-Repositories.

Wie lautet der Link zu Eurem GitHub-Repository?
`inputfield`

## Coding: Bestellstatus

[x]
Fügt einen Bestellstatus zu der Order hinzu (PROCESSING, IN_DELIVERY, COMPLETED), um den Status der Order zu bestimmen.
[x]
Legt dazu einen neuen Branch an[x], erstellt und pusht die Commits[x], erstellt einen Pull-Request[x], reviewet den PR und merged ihn in den main-Branch[x].
[x]
Wie lautet der Link zu Eurem Pull-Request?
`inputfield`

## Coding: Bestellstatus
[x]
Schreibt in dem ShopService eine Methode, die alle Bestellungen mit einem bestimmten Bestellstatus (Parameter) in einer Liste zurückgibt. Nutzt dafür Streams.

## Coding: Optional Product
[x]
Bearbeitet die Methode 'getProductById' in eurem ProductRepo, sodass sie ein Optional<Product> zurückgibt, wenn das Produkt existiert, andernfalls ein leeres Optional.

## Coding: Exceptions
[x]
Bearbeitet die Methode 'addOrder' im ShopService, sodass eine Exception geworfen wird, wenn das Product nicht vorhanden ist.

## Coding: Lombok
[]
Fügt eine 'updateOrder' Methode im ShopService hinzu, die anhand einer orderId und einem neuen Bestellstatus die Order aktualisiert. Nutze dafür Lombok `@With` Annotation.

## Coding: Bestelldatum

Erweitert das Order-Objekt um ein Feld, das den Bestellzeitpunkt speichert. In der 'addOrder' Methode soll dieses Feld mit dem aktuellen Zeitpunkt befüllt werden.

Dieser Zeitpunkt soll vor Gericht als Nachweis verwendet werden können, wenn Besteller\*innen behaupten, die Bestellung gar nicht aufgegeben zu haben. Überlegt Euch, welcher Datentyp dafür am besten geeignet ist - auch wenn Besteller\*innen aus dem Ausland bestellen.

## Bonus: in Main Repo festlegen

Erstellt eine Main-Klasse mit main-Methode. In dieser Methode erstellt eine Instanz des Shop-Services.

Auch die konkreten Instanzen für OrderRepo und ShopRepo sollen hier in der main-Methode erstellt werden. Übergebt sie dem ShopService-Konstruktor. Nutzt die `@RequiredArgsConstructor`-Annotation im Shop-Service um einen entsprechenden Konstruktor zu generieren.

Legt drei konkrete Bestellungen fest und fügt sie alle dem ShopService hinzu.

## Bonus: ID-Erstellung

Erstellt für die Erstellung einer ID einen `IdService`, der in der Methode `generateId` jeweils eine neue UUID zurückgibt (mithilfe von `java.util.UUID`). Erstellt eine konkrete Implementierung des `IdService` in der main-Methode und übergebt sie dem ShopService-Konstruktor.

## Bonus: Liegengebliebenes

Schreibt eine Methode `getOldestOrderPerStatus`, die eine Map mit dem ältesten Order-Objekt pro Status zurückgibt.

## Bonus: Transaktions-File

Lass die Main-Methode eine Datei `transactions.txt` einlesen, in diesem Format:
```
addOrder A 1 2 3
addOrder B 4 1
setStatus A COMPLETED
printOrders
```

Diese Datei soll eine Liste von Befehlszeilen enthalten, die der ShopService ausführen soll.

Folgende Befehlszeilen sollen unterstützt werden:

---

`addOrder`

Fügt eine neue Bestellung hinzu. Die Bestellung soll die übergebenen Produkt-IDs enthalten. Die Bestellung soll den Status `PROCESSING` haben.

`addOrder <alias for order within file> <productId> [<productId> ...]`

Speichert die OrderID, die Euch der ShopService zurückgibt, in einer Datenstruktur (zu dem angegebenen, frei wählbaren Alias), sodass Ihr später den Status der Bestellung ändern könnt.

---

`setStatus`

Setzt den Status einer Bestellung.

`setStatus <alias for order within file> <status>`

---

`printOrders`

Gibt alle Bestellungen aus.

## Bonus: Mengenangaben und Lagerbestände

Fügt eine Mengenangabe zu den Produkten hinzu. Wenn ein Produkt bestellt wird, wird die Menge des Produkts verringert. Wenn ein Produkt nicht mehr auf Lager ist, kann es nicht mehr bestellt werden. Lasse auch Fließkommazahlen zu. Und erweitere die Befehlsverarbeitung mit `transactions.txt` entsprechend.
