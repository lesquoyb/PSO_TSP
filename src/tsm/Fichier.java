package tsm;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom.*;
import org.jdom.output.*;


/**
 * La classe Fichier sert a gerer les fichier XML contenant les differentes cartes/villes dont le programme a besoin. 
 * @see Carte
 * @see Ville
 * @author Sebastien & Nathanael
 * @version 2.0
 */
public class Fichier
{
        /**
         * Le champ contenant le nom du fichier XMl (par defaut :"Dossier_carte.xml")  
         */
        public static final String nom_fichier = "Dossier_carte.xml";
        
        //création de la racine XML
        static Element racine = new Element("Liste_carte");
        //création d'un nouveau Document JDOM basé sur la racine que l'on vient de créer
        static org.jdom.Document document = new Document(racine);
        
        /**
         * Constructeur du fichier XML, attribuant les différentes villes/cartes au fichier
         */
        static void creer(){
                // Crée la carte France 
               Element carte = new Element("carte");
              racine.addContent(carte);
              Attribute nom_carte = new Attribute("nom","France");
              carte.setAttribute(nom_carte);
             
              //Ajoute des villes
              Element ville = new Element("ville");
              carte.addContent(ville);
              //Ajout attribut sur les villes
              Attribute nom = new Attribute("nom","Metz");
              ville.setAttribute(nom);
              Attribute x = new Attribute("x","0.0");
              ville.setAttribute(x);
              Attribute y = new Attribute("y","0.0");
              ville.setAttribute(y);
              
              Element ville2 = new Element("ville");
              carte.addContent(ville2);
              
              Attribute nom1 = new Attribute("nom","Strasbourg");
              ville2.setAttribute(nom1);
              Attribute x1 = new Attribute("x","1.0");
              ville2.setAttribute(x1);
              Attribute y1 = new Attribute("y","0.0");
              ville2.setAttribute(y1);
              
              Element ville3 = new Element("ville");
              carte.addContent(ville3);
              
              Attribute nom2 = new Attribute("nom","Verdun");
              ville3.setAttribute(nom2);
              Attribute x2 = new Attribute("x","0.0");
              ville3.setAttribute(x2);
              Attribute y2 = new Attribute("y","1.0");
              ville3.setAttribute(y2);
              
              
              Element ville4 = new Element("ville");
              carte.addContent(ville4);
              
              Attribute nom3 = new Attribute("nom","Reims");
              ville4.setAttribute(nom3);
              Attribute x3 = new Attribute("x","1.0");
              ville4.setAttribute(x3);
              Attribute y3 = new Attribute("y","1.0");
              ville4.setAttribute(y3);
              
              //Meilleur chemin France
              Element Meilleur_Chemin_France = new Element("Meilleur_Chemin");
              carte.addContent(Meilleur_Chemin_France);
              
              Element ville_1 = new Element("ville");
              Meilleur_Chemin_France.addContent(ville_1);
              Attribute nom_1 = new Attribute("nom","Metz");
              ville_1.setAttribute(nom_1);
              Attribute x_m_fr_1 = new Attribute("x","0.0");
              ville_1.setAttribute(x_m_fr_1);
              Attribute y_m_fr_1 = new Attribute("y","0.0");
              ville_1.setAttribute(y_m_fr_1);
              
              Element ville_2 = new Element("ville");
              Meilleur_Chemin_France.addContent(ville_2);
              Attribute nom_2 = new Attribute("nom","Strasbourg");
              ville_2.setAttribute(nom_2); 
              Attribute x_m_fr_2 = new Attribute("x","1.0");
              ville_2.setAttribute(x_m_fr_2);
              Attribute y_m_fr_2 = new Attribute("y","0.0");
              ville_2.setAttribute(y_m_fr_2);
              
              Element ville_3 = new Element("ville");
              Meilleur_Chemin_France.addContent(ville_3);
              Attribute nom_3 = new Attribute("nom","Reims");
              ville_3.setAttribute(nom_3); 
              Attribute x_m_fr_3 = new Attribute("x","1.0");
              ville_3.setAttribute(x_m_fr_3);
              Attribute y_m_fr_3 = new Attribute("y","1.0");
              ville_3.setAttribute(y_m_fr_3);
              
              Element ville_4 = new Element("ville");
              Meilleur_Chemin_France.addContent(ville_4);
              Attribute nom_4 = new Attribute("nom","Verdun");
              ville_4.setAttribute(nom_4);
              Attribute x_m_fr_4 = new Attribute("x","0.0");
              ville_4.setAttribute(x_m_fr_4);
              Attribute y_m_fr_4 = new Attribute("y","1.0");
              ville_4.setAttribute(y_m_fr_4);
              
              Element ville_5 = new Element("ville");
              Meilleur_Chemin_France.addContent(ville_5);
              Attribute nom_5 = new Attribute("nom","Metz");
              ville_5.setAttribute(nom_5);
              Attribute x_m_fr_5 = new Attribute("x","0.0");
              ville_5.setAttribute(x_m_fr_5);
              Attribute y_m_fr_5 = new Attribute("y","0.0");
              ville_5.setAttribute(y_m_fr_5);
                   
              
                // Crée la carte Espagne 
               Element carte1 = new Element("carte");
              racine.addContent(carte1);
              Attribute nom_carte1 = new Attribute("nom","Espagne");
              carte1.setAttribute(nom_carte1);
             
              //Ajoute des villes
              Element ville_esp1 = new Element("ville");
              carte1.addContent(ville_esp1);
              //Ajout attribut sur les villes
              Attribute nom_esp = new Attribute("nom","Madrid");
              ville_esp1.setAttribute(nom_esp);
              Attribute x_esp = new Attribute("x","0.0");
              ville_esp1.setAttribute(x_esp);
              Attribute y_esp = new Attribute("y","0.0");
              ville_esp1.setAttribute(y_esp);
              
              Element ville_esp2 = new Element("ville");
              carte1.addContent(ville_esp2);
              
              Attribute nom_esp1 = new Attribute("nom","Barcelone");
              ville_esp2.setAttribute(nom_esp1);
              Attribute x_esp1 = new Attribute("x","1.0");
              ville_esp2.setAttribute(x_esp1);
              Attribute y_esp1 = new Attribute("y","0.0");
              ville_esp2.setAttribute(y_esp1);
              
              Element ville_esp3 = new Element("ville");
              carte1.addContent(ville_esp3);
              
              Attribute nom_esp2 = new Attribute("nom","Grenade");
              ville_esp3.setAttribute(nom_esp2);
              Attribute x_esp2 = new Attribute("x","0.0");
              ville_esp3.setAttribute(x_esp2);
              Attribute y_esp2 = new Attribute("y","1.0");
              ville_esp3.setAttribute(y_esp2);
              
              Element ville_esp4 = new Element("ville");
              carte1.addContent(ville_esp4);
              
               Attribute nom_esp3 = new Attribute("nom","Salamanca");
              ville_esp4.setAttribute(nom_esp3);
              Attribute x_esp3 = new Attribute("x","1.0");
              ville_esp4.setAttribute(x_esp3);
              Attribute y_esp3 = new Attribute("y","1.0");
              ville_esp4.setAttribute(y_esp3);
              
              Element ville_esp5 = new Element("ville");
              carte1.addContent(ville_esp5);
              
              Attribute nom_esp4 = new Attribute("nom","Valencia");
              ville_esp5.setAttribute(nom_esp4);
              Attribute x_esp4 = new Attribute("x","2.0");
              ville_esp5.setAttribute(x_esp4);
              Attribute y_esp4 = new Attribute("y","0.5");
              ville_esp5.setAttribute(y_esp4);
              
              
            //Meilleur chemin Espagne
              Element Meilleur_Chemin_Espagne = new Element("Meilleur_Chemin");
              carte1.addContent(Meilleur_Chemin_Espagne);
              
              Element ville_esp_1 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_1);
              Attribute nom_esp_1 = new Attribute("nom","Madrid");
              ville_esp_1.setAttribute(nom_esp_1);
              Attribute x_m_es_1 = new Attribute("x","0.0");
              ville_esp_1.setAttribute(x_m_es_1);
              Attribute y_m_es_1 = new Attribute("y","0.0");
              ville_esp_1.setAttribute(y_m_es_1);
              
              Element ville_esp_2 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_2);
              Attribute nom_esp_2 = new Attribute("nom","Barcelone");
              ville_esp_2.setAttribute(nom_esp_2); 
              Attribute x_m_es_2 = new Attribute("x","1.0");
              ville_esp_2.setAttribute(x_m_es_2);
              Attribute y_m_es_2 = new Attribute("y","0.0");
              ville_esp_2.setAttribute(y_m_es_2);
              
              Element ville_esp_3 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_3);
              Attribute nom_esp_3 = new Attribute("nom","Valencia");
              ville_esp_3.setAttribute(nom_esp_3);
              Attribute x_m_es_3 = new Attribute("x","2.0");
              ville_esp_3.setAttribute(x_m_es_3);
              Attribute y_m_es_3 = new Attribute("y","0.5");
              ville_esp_3.setAttribute(y_m_es_3);
              
              Element ville_esp_4 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_4);
              Attribute nom_esp_4 = new Attribute("nom","Salamanca");
              ville_esp_4.setAttribute(nom_esp_4);
              Attribute x_m_es_4 = new Attribute("x","1.0");
              ville_esp_4.setAttribute(x_m_es_4);
              Attribute y_m_es_4 = new Attribute("y","1.0");
              ville_esp_4.setAttribute(y_m_es_4);
              
              Element ville_esp_5 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_5);
              Attribute nom_esp_5 = new Attribute("nom","Grenade");
              ville_esp_5.setAttribute(nom_esp_5);
              Attribute x_m_es_5 = new Attribute("x","0.0");
              ville_esp_5.setAttribute(x_m_es_5);
              Attribute y_m_es_5 = new Attribute("y","1.0");
              ville_esp_5.setAttribute(y_m_es_5);
              
              Element ville_esp_6 = new Element("ville");
              Meilleur_Chemin_Espagne.addContent(ville_esp_6);
              Attribute nom_esp_6 = new Attribute("nom","Madrid");
              ville_esp_6.setAttribute(nom_esp_6);
              Attribute x_m_es_6 = new Attribute("x","0.0");
              ville_esp_6.setAttribute(x_m_es_6);
              Attribute y_m_es_6 = new Attribute("y","0.0");
              ville_esp_6.setAttribute(y_m_es_6);
              
              
              // Crée la carte Portugal 
               Element carte2 = new Element("carte");
              racine.addContent(carte2);
              Attribute nom_carte2 = new Attribute("nom","Portugal");
              carte2.setAttribute(nom_carte2);
             
              //Ajoute des villes
              Element ville_por = new Element("ville");
              carte2.addContent(ville_por);
              //Ajout attribut sur les villes
              Attribute nom_por = new Attribute("nom","Porto");
              ville_por.setAttribute(nom_por);
              Attribute x_por = new Attribute("x","0.0");
              ville_por.setAttribute(x_por);
              Attribute y_por = new Attribute("y","0.0");
              ville_por.setAttribute(y_por);
              
              Element ville_por1 = new Element("ville");
              carte2.addContent(ville_por1);
              
              Attribute nom_por1 = new Attribute("nom","Lisbonne");
              ville_por1.setAttribute(nom_por1);
              Attribute x_por1 = new Attribute("x","0.0");
              ville_por1.setAttribute(x_por1);
              Attribute y_por1 = new Attribute("y","1.0");
              ville_por1.setAttribute(y_por1);
              
              Element ville_por2 = new Element("ville");
              carte2.addContent(ville_por2);
              
              Attribute nom_por2 = new Attribute("nom","Guarda");
              ville_por2.setAttribute(nom_por2);
              Attribute x_por2 = new Attribute("x","1.5");
              ville_por2.setAttribute(x_por2);
              Attribute y_por2 = new Attribute("y","2.0");
              ville_por2.setAttribute(y_por2);
              
              Element ville_por3 = new Element("ville");
              carte2.addContent(ville_por3);
              
              Attribute nom_por3 = new Attribute("nom","Peniche");
              ville_por3.setAttribute(nom_por3);
              Attribute x_por3 = new Attribute("x","1.0");
              ville_por3.setAttribute(x_por3);
              Attribute y_por3 = new Attribute("y","0.0");
              ville_por3.setAttribute(y_por3);
              
              
              //Meilleur chemin Portugal
              Element Meilleur_Chemin_Portugal = new Element("Meilleur_Chemin");
              carte2.addContent(Meilleur_Chemin_Portugal);
              
              Element ville_port_1 = new Element("ville");
              Meilleur_Chemin_Portugal.addContent(ville_port_1);
              Attribute nom_port_1 = new Attribute("nom","Porto");
              ville_port_1.setAttribute(nom_port_1);
              Attribute x_m_po_1 = new Attribute("x","0.0");
              ville_port_1.setAttribute(x_m_po_1);
              Attribute y_m_po_1 = new Attribute("y","0.0");
              ville_port_1.setAttribute(y_m_po_1);
              
              Element ville_port_2 = new Element("ville");
              Meilleur_Chemin_Portugal.addContent(ville_port_2);
              Attribute nom_port_2 = new Attribute("nom","Lisbonne");
              ville_port_2.setAttribute(nom_port_2); 
              Attribute x_m_po_2 = new Attribute("x","0.0");
              ville_port_2.setAttribute(x_m_po_2);
              Attribute y_m_po_2 = new Attribute("y","1.0");
              ville_port_2.setAttribute(y_m_po_2);
              
              Element ville_port_3 = new Element("ville");
              Meilleur_Chemin_Portugal.addContent(ville_port_3);
              Attribute nom_port_3 = new Attribute("nom","Guarda");
              ville_port_3.setAttribute(nom_port_3);
              Attribute x_m_po_3 = new Attribute("x","1.5");
              ville_port_3.setAttribute(x_m_po_3);
              Attribute y_m_po_3 = new Attribute("y","2.0");
              ville_port_3.setAttribute(y_m_po_3);
              
              Element ville_port_4 = new Element("ville");
              Meilleur_Chemin_Portugal.addContent(ville_port_4);
              Attribute nom_port_4 = new Attribute("nom","Peniche");
              ville_port_4.setAttribute(nom_port_4);
              Attribute x_m_po_4 = new Attribute("x","1.0");
              ville_port_4.setAttribute(x_m_po_4);
              Attribute y_m_po_4 = new Attribute("y","0.0");
              ville_port_4.setAttribute(y_m_po_4);
              
              Element ville_port_5 = new Element("ville");
              Meilleur_Chemin_Portugal.addContent(ville_port_5);
              Attribute nom_port_5 = new Attribute("nom","Porto");
              ville_port_5.setAttribute(nom_port_5);
              Attribute x_m_po_5 = new Attribute("x","0.0");
              ville_port_5.setAttribute(x_m_po_5);
              Attribute y_m_po_5 = new Attribute("y","0.0");
              ville_port_5.setAttribute(y_m_po_5);
                   
              
              
              
           // Crée la carte Angleterre  
          Element carte3 = new Element("carte");
         racine.addContent(carte3);
         Attribute nom_carte3 = new Attribute("nom","Angleterre");
         carte3.setAttribute(nom_carte3);
        
         //Ajoute des villes
         Element ville_ang = new Element("ville");
         carte3.addContent(ville_ang);
         //Ajout attribut sur les villes
         Attribute nom_ang = new Attribute("nom","Londres");
         ville_ang.setAttribute(nom_ang);
         Attribute x_ang = new Attribute("x","-1.0");
         ville_ang.setAttribute(x_ang);
         Attribute y_ang = new Attribute("y","-1.0");
         ville_ang.setAttribute(y_ang);
         
         Element ville_ang2 = new Element("ville");
         carte3.addContent(ville_ang2);
         
          Attribute nom_ang1 = new Attribute("nom","Norwich");
         ville_ang2.setAttribute(nom_ang1);
         Attribute x_ang1 = new Attribute("x","-1.0");
         ville_ang2.setAttribute(x_ang1);
         Attribute y_ang1 = new Attribute("y","1.0");
         ville_ang2.setAttribute(y_ang1);
         
          Element ville_ang3 = new Element("ville");
         carte3.addContent(ville_ang3);
         
          Attribute nom_ang2 = new Attribute("nom","Oxford");
         ville_ang3.setAttribute(nom_ang2);
         Attribute x_ang2 = new Attribute("x","2.0");
         ville_ang3.setAttribute(x_ang2);
         Attribute y_ang2 = new Attribute("y","1.0");
         ville_ang3.setAttribute(y_ang2);
         
         Element ville_ang4 = new Element("ville");
         carte3.addContent(ville_ang4);
         
          Attribute nom_ang3 = new Attribute("nom","Cambridge");
         ville_ang4.setAttribute(nom_ang3);
         Attribute x_ang3 = new Attribute("x","2.0");
         ville_ang4.setAttribute(x_ang3);
         Attribute y_ang3 = new Attribute("y","-1.0");
         ville_ang4.setAttribute(y_ang3);
         
          //Meilleur chemin Angleterre
         Element Meilleur_Chemin_Angleterre = new Element("Meilleur_Chemin");
         carte3.addContent(Meilleur_Chemin_Angleterre);
         
         Element ville_ang_1 = new Element("ville");
         Meilleur_Chemin_Angleterre.addContent(ville_ang_1);
         Attribute nom_ang_1 = new Attribute("nom","Londres");
         ville_ang_1.setAttribute(nom_ang_1);
         Attribute x_m_an_1 = new Attribute("x","-1.0");
         ville_ang_1.setAttribute(x_m_an_1);
         Attribute y_m_an_1 = new Attribute("y","-1.0");
         ville_ang_1.setAttribute(y_m_an_1);
         
         Element ville_ang_2 = new Element("ville");
         Meilleur_Chemin_Angleterre.addContent(ville_ang_2);
         Attribute nom_ang_2 = new Attribute("nom","Norwich");
         ville_ang_2.setAttribute(nom_ang_2); 
         Attribute x_m_an_2 = new Attribute("x","-1.0");
         ville_ang_2.setAttribute(x_m_an_2);
         Attribute y_m_an_2 = new Attribute("y","1.0");
         ville_ang_2.setAttribute(y_m_an_2);
         
         Element ville_ang_3 = new Element("ville");
         Meilleur_Chemin_Angleterre.addContent(ville_ang_3);
         Attribute nom_ang_3 = new Attribute("nom","Oxford");
         ville_ang_3.setAttribute(nom_ang_3); 
         Attribute x_m_an_3 = new Attribute("x","2.0");
         ville_ang_3.setAttribute(x_m_an_3);
         Attribute y_m_an_3 = new Attribute("y","1.0");
         ville_ang_3.setAttribute(y_m_an_3);
         
         Element ville_ang_4 = new Element("ville");
         Meilleur_Chemin_Angleterre.addContent(ville_ang_4);
         Attribute nom_ang_4 = new Attribute("nom","Cambridge");
         ville_ang_4.setAttribute(nom_ang_4);
         Attribute x_m_an_4 = new Attribute("x","2.0");
         ville_ang_4.setAttribute(x_m_an_4);
         Attribute y_m_an_4 = new Attribute("y","-1.0");
         ville_ang_4.setAttribute(y_m_an_4);
         
         Element ville_ang_5 = new Element("ville");
         Meilleur_Chemin_Angleterre.addContent(ville_ang_5);
         Attribute nom_ang_5 = new Attribute("nom","Londres");
         ville_ang_5.setAttribute(nom_ang_5);
         Attribute x_m_an_5 = new Attribute("x","-1.0");
         ville_ang_5.setAttribute(x_m_an_5);
         Attribute y_m_an_5 = new Attribute("y","-1.0");
         ville_ang_5.setAttribute(y_m_an_5);
         
         
         // Crée la carte Hardland  
       Element carte4 = new Element("carte");
       racine.addContent(carte4);
       Attribute nom_carte4 = new Attribute("nom","Villes de France");
       carte4.setAttribute(nom_carte4);
       
       Element ville_hard12 = new Element("ville");
       carte4.addContent(ville_hard12);
       Attribute nom_hard12 = new Attribute("nom","Paris");
       ville_hard12.setAttribute(nom_hard12);
       Attribute x_hard12 = new Attribute("x","0.0");
       ville_hard12.setAttribute(x_hard12);
       Attribute y_hard12 = new Attribute("y","0.0");
       ville_hard12.setAttribute(y_hard12);
       
       Element ville_hard1 = new Element("ville");
       carte4.addContent(ville_hard1);
        Attribute nom_hard1 = new Attribute("nom","Marseille");
       ville_hard1.setAttribute(nom_hard1);
       Attribute x_hard1 = new Attribute("x","200.0");
       ville_hard1.setAttribute(x_hard1);
       Attribute y_hard1 = new Attribute("y","-700.0");
       ville_hard1.setAttribute(y_hard1);
       
       
       Element ville_hard2 = new Element("ville");
       carte4.addContent(ville_hard2);
        Attribute nom_hard2 = new Attribute("nom","Lyon");
       ville_hard2.setAttribute(nom_hard2);
       Attribute x_hard2 = new Attribute("x","170.0");
       ville_hard2.setAttribute(x_hard2);
       Attribute y_hard2 = new Attribute("y","-350.0");
       ville_hard2.setAttribute(y_hard2);
       
       Element ville_hard3 = new Element("ville");
       carte4.addContent(ville_hard3);
        Attribute nom_hard3 = new Attribute("nom","Toulouse");
       ville_hard3.setAttribute(nom_hard3);
       Attribute x_hard3 = new Attribute("x","-65.0");
       ville_hard3.setAttribute(x_hard3);
       Attribute y_hard3 = new Attribute("y","-640.0");
       ville_hard3.setAttribute(y_hard3);
       
       Element ville_hard4 = new Element("ville");
       carte4.addContent(ville_hard4);
       Attribute nom_hard4 = new Attribute("nom","Nice");
       ville_hard4.setAttribute(nom_hard4);
       Attribute x_hard4 = new Attribute("x","360.0");
       ville_hard4.setAttribute(x_hard4);
       Attribute y_hard4 = new Attribute("y","-580.0");
       ville_hard4.setAttribute(y_hard4);
       
       Element ville_hard5 = new Element("ville");
       carte4.addContent(ville_hard5);
       Attribute nom_hard5 = new Attribute("nom","Nantes");
       ville_hard5.setAttribute(nom_hard5);
       Attribute x_hard5 = new Attribute("x","-280.0");
       ville_hard5.setAttribute(x_hard5);
       Attribute y_hard5 = new Attribute("y","-180.0");
       ville_hard5.setAttribute(y_hard5);
       
       Element ville_hard6 = new Element("ville");
       carte4.addContent(ville_hard6);
       Attribute nom_hard6 = new Attribute("nom","Strasbourg");
       ville_hard6.setAttribute(nom_hard6);
       Attribute x_hard6 = new Attribute("x","400.0");
       ville_hard6.setAttribute(x_hard6);
       Attribute y_hard6 = new Attribute("y","-40.0");
       ville_hard6.setAttribute(y_hard6);
      
       Element ville_hard7 = new Element("ville");
       carte4.addContent(ville_hard7);
       Attribute nom_hard7 = new Attribute("nom","Lille");
       ville_hard7.setAttribute(nom_hard7);
       Attribute x_hard7 = new Attribute("x","40.0");
       ville_hard7.setAttribute(x_hard7);
       Attribute y_hard7 = new Attribute("y","190.0");
       ville_hard7.setAttribute(y_hard7);
       
       Element ville_hard8 = new Element("ville");
       carte4.addContent(ville_hard8);
       Attribute nom_hard8 = new Attribute("nom","Montpellier");
       ville_hard8.setAttribute(nom_hard8);
       Attribute x_hard8 = new Attribute("x","100.0");
       ville_hard8.setAttribute(x_hard8);
       Attribute y_hard8 = new Attribute("y","-650.0");
       ville_hard8.setAttribute(y_hard8);
       
       Element ville_hard9 = new Element("ville");
       carte4.addContent(ville_hard9);
       Attribute nom_hard9 = new Attribute("nom","Bordeaux");
       ville_hard9.setAttribute(nom_hard9);
       Attribute x_hard9 = new Attribute("x","-210.0");
       ville_hard9.setAttribute(x_hard9);
       Attribute y_hard9 = new Attribute("y","-430.0");
       ville_hard9.setAttribute(y_hard9);
       
       Element ville_hard10 = new Element("ville");
       carte4.addContent(ville_hard10);
       Attribute nom_hard10 = new Attribute("nom","Rennes");
       ville_hard10.setAttribute(nom_hard10);
       Attribute x_hard10 = new Attribute("x","-290.0");
       ville_hard10.setAttribute(x_hard10);
       Attribute y_hard10 = new Attribute("y","-85.0");
       ville_hard10.setAttribute(y_hard10);
       
       Element ville_hard11 = new Element("ville");
       carte4.addContent(ville_hard11);
       Attribute nom_hard11 = new Attribute("nom","Le Havre");
       ville_hard11.setAttribute(nom_hard11);
       Attribute x_hard11 = new Attribute("x","-145.4");
       ville_hard11.setAttribute(x_hard11);
       Attribute y_hard11 = new Attribute("y","65.5");
       ville_hard11.setAttribute(y_hard11);
       
       
       Element ville_hard13 = new Element("ville");
       carte4.addContent(ville_hard13);
       Attribute nom_hard13 = new Attribute("nom","Reims");
       ville_hard13.setAttribute(nom_hard13);
       Attribute x_hard13 = new Attribute("x","120.0");
       ville_hard13.setAttribute(x_hard13);
       Attribute y_hard13 = new Attribute("y","50.4");
       ville_hard13.setAttribute(y_hard13);
       
       Element ville_hard14 = new Element("ville");
       carte4.addContent(ville_hard14);
       Attribute nom_hard14 = new Attribute("nom","Saint-Etienne");
       ville_hard14.setAttribute(nom_hard14);
       Attribute x_hard14 = new Attribute("x","140.0");
       ville_hard14.setAttribute(x_hard14);
       Attribute y_hard14 = new Attribute("y","-370.0");
       ville_hard14.setAttribute(y_hard14);
       
       Element ville_hard15 = new Element("ville");
       carte4.addContent(ville_hard15);
       Attribute nom_hard15 = new Attribute("nom","Toulon");
       ville_hard15.setAttribute(nom_hard15);
       Attribute x_hard15 = new Attribute("x","240.0");
       ville_hard15.setAttribute(x_hard15);
       Attribute y_hard15 = new Attribute("y","-715.0");
       ville_hard15.setAttribute(y_hard15);
       
       //Meilleur chemin hard
       Element Meilleur_Chemin_Hard = new Element("Meilleur_Chemin");
       carte4.addContent(Meilleur_Chemin_Hard);
       
       Element ville_hard_1 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_1);
       Attribute nom_hard_1 = new Attribute("nom","Paris");
       ville_hard_1.setAttribute(nom_hard_1);
       Attribute x_m_hard_1 = new Attribute("x","0.0");
       ville_hard_1.setAttribute(x_m_hard_1);
       Attribute y_m_hard_1 = new Attribute("y","0.0");
       ville_hard_1.setAttribute(y_m_hard_1);
       
       Element ville_hard_2 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_2);
       Attribute nom_hard_2 = new Attribute("nom","Le Havre");
       ville_hard_2.setAttribute(nom_hard_2);
       Attribute x_m_hard_2 = new Attribute("x","-145.4");
       ville_hard_2.setAttribute(x_m_hard_2);
       Attribute y_m_hard_2 = new Attribute("y","65.5");
       ville_hard_2.setAttribute(y_m_hard_2);
       
       Element ville_hard_3 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_3);
       Attribute nom_hard_3 = new Attribute("nom","Nantes");
       ville_hard_3.setAttribute(nom_hard_3);
       Attribute x_m_hard_3 = new Attribute("x","-280.0");
       ville_hard_3.setAttribute(x_m_hard_3);
       Attribute y_m_hard_3 = new Attribute("y","-180.0");
       ville_hard_3.setAttribute(y_m_hard_3);
       
       Element ville_hard_4 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_4);
       Attribute nom_hard_4 = new Attribute("nom","Rennes");
       ville_hard_4.setAttribute(nom_hard_4);
       Attribute x_m_hard_4 = new Attribute("x","-290.0");
       ville_hard_4.setAttribute(x_m_hard_4);
       Attribute y_m_hard_4 = new Attribute("y","-85.0");
       ville_hard_4.setAttribute(y_m_hard_4);
       
       Element ville_hard_5 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_5);
       Attribute nom_hard_5 = new Attribute("nom","Bordeaux");
       ville_hard_5.setAttribute(nom_hard_5);
       Attribute x_m_hard_5 = new Attribute("x","-210.0");
       ville_hard_5.setAttribute(x_m_hard_5);
       Attribute y_m_hard_5 = new Attribute("y","-430.0");
       ville_hard_5.setAttribute(y_m_hard_5);
       
       Element ville_hard_6 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_6);
       Attribute nom_hard_6 = new Attribute("nom","Toulouse");
       ville_hard_6.setAttribute(nom_hard_6);
       Attribute x_m_hard_6 = new Attribute("x","-65.0");
       ville_hard_6.setAttribute(x_m_hard_6);
       Attribute y_m_hard_6 = new Attribute("y","-640.0");
       ville_hard_6.setAttribute(y_m_hard_6);
       
       Element ville_hard_7 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_7);
       Attribute nom_hard_7 = new Attribute("nom","Marseille");
       ville_hard_7.setAttribute(nom_hard_7);
       Attribute x_m_hard_7 = new Attribute("x","200.0");
       ville_hard_7.setAttribute(x_m_hard_7);
       Attribute y_m_hard_7 = new Attribute("y","-700.0");
       ville_hard_7.setAttribute(y_m_hard_7);
       
       Element ville_hard_8 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_8);
       Attribute nom_hard_8 = new Attribute("nom","Montpelliers");
       ville_hard_8.setAttribute(nom_hard_8);
       Attribute x_m_hard_8 = new Attribute("x","100.0");
       ville_hard_8.setAttribute(x_m_hard_8);
       Attribute y_m_hard_8 = new Attribute("y","-650.0");
       ville_hard_8.setAttribute(y_m_hard_8);
       
       Element ville_hard_9 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_9);
       Attribute nom_hard_9 = new Attribute("nom","Toulon");
       ville_hard_9.setAttribute(nom_hard_9);
       Attribute x_m_hard_9 = new Attribute("x","240.0");
       ville_hard_9.setAttribute(x_m_hard_9);
       Attribute y_m_hard_9 = new Attribute("y","-715.0");
       ville_hard_9.setAttribute(y_m_hard_9);
       
       Element ville_hard_10 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_10);
       Attribute nom_hard_10 = new Attribute("nom","Nice");
       ville_hard_10.setAttribute(nom_hard_10);
       Attribute x_m_hard_10 = new Attribute("x","360.0");
       ville_hard_10.setAttribute(x_m_hard_10);
       Attribute y_m_hard_10 = new Attribute("y","-580.0");
       ville_hard_10.setAttribute(y_m_hard_10);
       
       Element ville_hard_11 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_11);
       Attribute nom_hard_11 = new Attribute("nom","Saint-Etienne");
       ville_hard_11.setAttribute(nom_hard_11);
       Attribute x_m_hard_11 = new Attribute("x","140.0");
       ville_hard_11.setAttribute(x_m_hard_11);
       Attribute y_m_hard_11 = new Attribute("y","-370.0");
       ville_hard_11.setAttribute(y_m_hard_11);
       
       Element ville_hard_12 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_12);
       Attribute nom_hard_12 = new Attribute("nom","Lyon");
       ville_hard_12.setAttribute(nom_hard_12);
       Attribute x_m_hard_12 = new Attribute("x","170.0");
       ville_hard_12.setAttribute(x_m_hard_12);
       Attribute y_m_hard_12 = new Attribute("y","-350.0");
       ville_hard_12.setAttribute(y_m_hard_12);
       
       Element ville_hard_13 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_13);
       Attribute nom_hard_13 = new Attribute("nom","Strasbourg");
       ville_hard_13.setAttribute(nom_hard_13);
       Attribute x_m_hard_13 = new Attribute("x","400.0");
       ville_hard_13.setAttribute(x_m_hard_13);
       Attribute y_m_hard_13 = new Attribute("y","-40.0");
       ville_hard_13.setAttribute(y_m_hard_13);
       
       Element ville_hard_14 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_14);
       Attribute nom_hard_14 = new Attribute("nom","Lille");
       ville_hard_14.setAttribute(nom_hard_14);
       Attribute x_m_hard_14 = new Attribute("x","40.0");
       ville_hard_14.setAttribute(x_m_hard_14);
       Attribute y_m_hard_14 = new Attribute("y","190.0");
       ville_hard_14.setAttribute(y_m_hard_14);
       
       Element ville_hard_15 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_15);
       Attribute nom_hard_15 = new Attribute("nom","Reims");
       ville_hard_15.setAttribute(nom_hard_15);
       Attribute x_m_hard_15 = new Attribute("x","120.0");
       ville_hard_15.setAttribute(x_m_hard_15);
       Attribute y_m_hard_15 = new Attribute("y","50.4");
       ville_hard_15.setAttribute(y_m_hard_15);
       
       Element ville_hard_16 = new Element("ville");
       Meilleur_Chemin_Hard.addContent(ville_hard_16);
       Attribute nom_hard_16 = new Attribute("nom","Paris");
       ville_hard_16.setAttribute(nom_hard_16);
       Attribute x_m_hard_16 = new Attribute("x","0.0");
       ville_hard_16.setAttribute(x_m_hard_16);
       Attribute y_m_hard_16 = new Attribute("y","0.0");
       ville_hard_16.setAttribute(y_m_hard_16);
       
            // on enregistre le fichier précedement crée avec comme nom, le nom par défaut
            enregistre(nom_fichier);
        }
   
        /**
         * Methode enregistrant le fichier XML crée par le constructeur
         */
   static void enregistre(String fichier)
   {
      try
      {
         
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(document, new FileOutputStream(fichier));
      }
      catch (java.io.IOException e){}
   }
   
   /**
    * Methode permetant de recherché une carte donné en paramètre, et la recherchant dans le fichier XML
    * Elle crée ainsi une Carte à partir de l'XML, et y ajoute les villes s'y trouvant ainsi que on meilleur chemin
    */
   public static Carte Rechercher_Carte (String nom_carte){
           Carte carte_recherchee = null;   
           List listeCarte = racine.getChildren("carte");   //liste de toute les cartes
           Iterator i = listeCarte.iterator();
           while(i.hasNext()){
                   Element courant = (Element)i.next();           // on parcours chaque carte
                   if(courant.getAttributeValue("nom") == nom_carte){   // si le nom corresponds à la carte recherchée
                           carte_recherchee = new Carte(nom_carte);
                           List listeVille = courant.getChildren("ville");  // Liste des villes de la carte
                           Iterator j = listeVille.iterator();        
                           while(j.hasNext())
                           {
                                   Element courant2 = (Element)j.next();                // on parcours de chaque ville
                                   carte_recherchee.Ajout_Ville(courant2.getAttributeValue("nom"),courant2.getAttributeValue("x"), courant2.getAttributeValue("y")); //on ajoute la ville (nom,position) à la carte
                           }
                           List meilleur = courant.getChildren("Meilleur_Chemin");
                           Iterator k = meilleur.iterator();
                           while(k.hasNext()){
                                   Element courant3 = (Element)k.next();
                                   List liste_meilleur_chemin = courant3.getChildren("ville");
                                   Iterator l = liste_meilleur_chemin.iterator();
                                   while (l.hasNext()){
                                       Element courant4 = (Element)l.next();
                                       carte_recherchee.Ajout_Meilleur(courant4.getAttributeValue("nom"),courant4.getAttributeValue("x"),courant4.getAttributeValue("y")) ; // on ajoute le meuilleur chemin
                                   }
                           }
                   }
           } 
           return carte_recherchee;
   }
   
   /**
    * Méthode permettant de retourner une Liste de carte
    * utilisée par {@link Panneau#menu_deroulant}
    */
   static ArrayList<String> Lister_Carte (){
           
           List liste = racine.getChildren("carte"); //on entre dans l'arboressence
           Iterator i = liste.iterator();
           ArrayList<String> listeNomCarte = new ArrayList<String>();
// On parcours toutes les balises "carte" et on ajoute les noms correspondant à la liste
           while (i.hasNext()){
                   Element nom = (Element)i.next();
                   listeNomCarte.add(nom.getAttributeValue("nom"));
           }
           return listeNomCarte;   
   }
}