package com.gestion1.univ;

import com.gestion1.univ.entitites.*;
import com.gestion1.univ.repositories.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UnivApplicationTests {

	@Autowired
	Etudiantrepository etudiantrepository;

	@Test
	public void TestCreateEtudiant() {
		Etudiant etudiant = new Etudiant();
		etudiantrepository.save(etudiant);

	}
   @Autowired
	Enseignantrepository enseignantrepository;

	@Test
	public void TestCreateEnseignant() {
		Enseignant enseignant = new Enseignant();
		enseignantrepository.save(enseignant);


	}
   @Autowired
	Etablissementrepository etablissementrepository;

	@Test
	public void TestCreateEtablissement() {
		Etablissement etablissement = new Etablissement();
		etablissementrepository.save(etablissement);


	}
@Autowired
	Emploidutempsrepository emploidutempsrepository;

	@Test
	public void TestCreateEmploidutemps() {
		Emploidutemps emploidutemps = new Emploidutemps();
		emploidutempsrepository.save(emploidutemps);
	}
	@Autowired
	Coursrepository coursrepository;

	@Test
	public void testCreateCours() {
		Cours cours = new Cours();

		coursrepository.save(cours);
	}
	@Autowired
	Filiererepository filiererepository;

	@Test
	public void testCreateFiliere() {
		Filiere filiere = new Filiere();

		filiererepository.save(filiere);
	}
	@Autowired
	Noterepository noterepository ;

	@Test
	public void testCreateNote() {
		Note note = new Note();

		noterepository.save(note);
	}
	@Autowired
	 Examenrepository  examenrepository ;

	@Test
	public void testCreateExamen() {
		 Examen examen=new Examen();
		 examenrepository.save(examen);


	}


}