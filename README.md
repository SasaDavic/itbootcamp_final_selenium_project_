# 🧪 Selenium UI Test Automation Project

Automatizovani UI testovi razvijeni u okviru IT Bootcamp završnog projekta, koristeći Java + Selenium + TestNG.

🔗 Testirana aplikacija: [Vue Admin Demo](https://vue-demo.daniel-avellaneda.com/)

---

## ✅ Pokriveni scenariji

- 🔐 Login sa validnim i nevalidnim podacima  
- 🚪 Logout i provera pristupa zaštićenim rutama  
- 🌍 Promena jezika aplikacije (locale switch)  
- 🏙️ CRUD operacije nad gradovima (Cities)  
- 🔄 Navigacija kroz admin meni  

---

## 🧰 Tehnologije

- Java 11  
- Selenium WebDriver  
- TestNG  
- ChromeDriver  
- Page Object Model (POM)

---

## 🧭 Struktura projekta

itbootcamp_final_selenium_project_/ ├── drivers/ # ChromeDriver ├── lib/ # .jar fajlovi za Selenium ├── pages/ # Page Object klase ├── tests/ # TestNG test klase ├── testng.xml # Test konfiguracija └── README.md # Opis projekta


---

## ▶️ Pokretanje projekta

1. **Kloniraj repozitorijum:**

   ```bash
   git clone https://github.com/SasaDavic/itbootcamp_final_selenium_project_
Dodaj Selenium .jar fajlove u lib/ folder ako nisu već tu.

Podesi putanju do chromedriver.exe u Base test klasi (ili koristi drivers/).

Pokreni testng.xml iz IDE-a (IntelliJ IDEA / Eclipse) ili preko komandne linije.

🔎 Napomene
Testovi koriste WebDriverWait i Actions za stabilno izvršavanje interakcija.

Elementi se identifikuju pomoću id, class, xpath, i text() selektora.

Kod je pisan modularno, sa naglaskom na ponovno korišćenje i čitljivost.

✍️ Autor
👤 Saša (Davić) Živković
📧 (po potrebi dopuni kontakt)

Ovaj projekat je deo završne vežbe na QA Selenium kursu u okviru IT Bootcamp programa.
