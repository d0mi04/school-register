# 📘 Dziennik lekcyjny – Projekt bazy danych SQL

## 📌 Opis projektu

Projekt przedstawia prostą relacyjną bazę danych SQL, która symuluje **dziennik lekcyjny** używany w szkołach. Celem jest umożliwienie zarządzania informacjami o uczniach, nauczycielach, klasach, przedmiotach, ocenach i obecnościach. Baza danych może być wykorzystana jako backend dla aplikacji edukacyjnej, e-dziennika lub systemu zarządzania szkołą.

---

## 🛠️ Technologie

- SQL (zgodne z MySQL / PostgreSQL)
- Narzędzia: DBeaver, MySQL Workbench, PostgreSQL, IntelliJ (backend opcjonalnie)

---

## 📊 Diagram ERD

![Diagram ERD](./erd_dziennik_lekcyjny.png)

---

## 🧩 Tabele w bazie danych

### 1. `students`
Reprezentuje uczniów w systemie.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator ucznia        |
| first_name      | VARCHAR(50)    | Imię                        |
| last_name       | VARCHAR(50)    | Nazwisko                    |
| email           | VARCHAR(100)   | E-mail                      |
| class_id        | INT (FK)       | Przynależność do klasy      |
| date_of_birth   | DATE           | Data urodzenia              |

---

### 2. `teachers`
Reprezentuje nauczycieli.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator nauczyciela   |
| first_name      | VARCHAR(50)    | Imię                        |
| last_name       | VARCHAR(50)    | Nazwisko                    |
| email           | VARCHAR(100)   | E-mail                      |

---

### 3. `subjects`
Lista przedmiotów.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator przedmiotu    |
| name            | VARCHAR(100)   | Nazwa przedmiotu            |

---

### 4. `classes`
Reprezentuje klasy szkolne.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator klasy         |
| name            | VARCHAR(20)    | Nazwa klasy (np. 1A)        |
| teacher_id      | INT (FK)       | Wychowawca                  |

---

### 5. `lessons`
Reprezentuje lekcje przeprowadzone w klasach.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator lekcji        |
| subject_id      | INT (FK)       | Przedmiot                   |
| teacher_id      | INT (FK)       | Nauczyciel prowadzący       |
| class_id        | INT (FK)       | Klasa                       |
| date            | DATE           | Data lekcji                 |
| topic           | VARCHAR(255)   | Temat lekcji                |

---

### 6. `grades`
Oceny wystawione uczniom.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator oceny         |
| student_id      | INT (FK)       | Uczeń                       |
| lesson_id       | INT (FK)       | Lekcja                      |
| grade           | VARCHAR(10)    | Ocena                       |
| comment         | TEXT           | Komentarz (opcjonalnie)     |

---

### 7. `attendance`
Rejestr obecności na lekcjach.
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Identyfikator obecności     |
| student_id      | INT (FK)       | Uczeń                       |
| lesson_id       | INT (FK)       | Lekcja                      |
| status          | VARCHAR(20)    | Status (np. obecny, spóźniony, nieobecny) |

---

### 8. `users`
Użytkownicy systemu (logowanie).
| Kolumna         | Typ danych     | Opis                        |
|------------------|----------------|-----------------------------|
| id              | INT (PK)       | Id użytkownika              |
| username        | VARCHAR(50)    | Nazwa użytkownika           |
| password_hash   | VARCHAR(255)   | Zaszyfrowane hasło          |
| role            | ENUM           | Rola (`admin`, `teacher`, `student`) |
| linked_id       | INT            | ID powiązany z `students` lub `teachers` |

---

## 🔧 Przykład użycia

W przyszłości możesz wykorzystać tę bazę do:

- tworzenia REST API w Javie lub Node.js,
- generowania raportów uczniów i klas,
- budowy prostego frontendu z logowaniem i listą ocen.

---

## 📂 Pliki

- `schema.sql` – zawiera wszystkie zapytania `CREATE TABLE`
- `erd_dziennik_lekcyjny.png` – diagram ERD (dołączony do repozytorium)
- `README.md` – ten plik z opisem

---

## 📣 Autor

Projekt edukacyjny stworzony do nauki projektowania baz danych.

