package by.jis4.komarov.bean;

import java.util.Objects;

public class Book {
    private String autor;
    private String name;
    private int countPage;

    public Book() {
    }

    public Book(String autor, String name, int countPage) {
        this.autor = autor;
        this.name = name;
        this.countPage = countPage;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return countPage == book.countPage &&
                Objects.equals(autor, book.autor) &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, name, countPage);
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", name='" + name + '\'' +
                ", countPage=" + countPage +
                '}';
    }
}
