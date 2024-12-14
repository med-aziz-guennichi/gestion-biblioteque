class Auteur {
    private String nom;
    private String nationalite;

    public Auteur(String nom, String nationalite) {
        this.nom = nom;
        this.nationalite = nationalite;
    }

    public String getNom() {
        return nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    @Override
    public String toString() {
        return "Auteur: " + nom + ", Nationalité: " + nationalite;
    }
}

// Classe Livre (finale)
final class Livre {
    private String titre;
    private Auteur auteur;
    private int anneePublication;
    private int nombrePages;

    public Livre(String titre, Auteur auteur, int anneePublication, int nombrePages) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.nombrePages = nombrePages;
    }

    public String getTitre() {
        return titre;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public int getNombrePages() {
        return nombrePages;
    }

    @Override
    public String toString() {
        return "Livre: " + titre + ", Auteur: [" + auteur + "], Année: " + anneePublication + ", Pages: " + nombrePages;
    }
}

// Classe d'exception personnalisée BibliothequeException
class BibliothequeException extends Exception {
    public BibliothequeException(String message) {
        super(message);
    }
}

// Classe Bibliotheque
class Bibliotheque {
    private Livre[] livres;
    private int count;

    public Bibliotheque(int taille) {
        livres = new Livre[taille];
        count = 0;
    }

    public void ajouterLivre(Livre livre) throws BibliothequeException {
        if (livre.getAnneePublication() > 2024) {
            throw new BibliothequeException("L'année de publication ne peut pas être dans le futur.");
        }
        if (livre.getAuteur() == null) {
            throw new BibliothequeException("Un livre doit avoir un auteur.");
        }
        if (count >= livres.length) {
            throw new BibliothequeException("La bibliothèque est pleine.");
        }
        livres[count++] = livre;
        System.out.println("Livre ajouté avec succès : " + livre.getTitre());
    }

    public void afficherLivres() {
        if (count == 0) {
            System.out.println("La bibliothèque est vide.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(livres[i]);
            }
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Bibliotheque bibliotheque = new Bibliotheque(5);

        Auteur auteur1 = new Auteur("Aziz Guennichi", "Tunisia");
        Livre livre1 = new Livre("EL wabna", auteur1, 1862, 1232);

        try {
            bibliotheque.ajouterLivre(livre1);
            Livre livre2 = new Livre("El t7in", auteur1, 2050, 300);
            bibliotheque.ajouterLivre(livre2);
        } catch (BibliothequeException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        bibliotheque.afficherLivres();
    }
}
