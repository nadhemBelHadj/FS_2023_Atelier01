package com.nadhem.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nadhem.produits.entities.Categorie;
import com.nadhem.produits.entities.Produit;
import com.nadhem.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ProduitRepository produitRepository;

	@Test
	 public void testCreateProduit() {
		Produit prod = new Produit("PC Dell3",2200.500,new Date());
		produitRepository.save(prod);
	}	
	
	   @Test
		public void testFindProduit()
		 {
			 Produit p = produitRepository.findById(1L).get();		  
			 System.out.println(p);
		 }

		@Test
		public void testUpdateProduit()
		 {
			 Produit p = produitRepository.findById(1L).get();
			 p.setPrixProduit(1000.0);
			 produitRepository.save(p);
		 }
		
		
	@Test
		public void testDeleteProduit()
		 {
			 produitRepository.deleteById(1L);;
			 
		 }

	   
	@Test
		public void testListerTousProduits()
		 {
			 List<Produit>  prods = produitRepository.findAll();	 
				for (Produit p : prods)
				{
					System.out.println(p);
				}	 
		 }
	
	@Test
	public void testFindByNomProduit()
	 {
	List<Produit>  prods = produitRepository.findByNomProduit("PC Dell2");
			for (Produit p : prods)
			{
				System.out.println(p);
			}
		
	 }
	
	@Test
	public void testFindByNomProduitContains ()
	 {
	List<Produit> prods=produitRepository.findByNomProduitContains("Dell");
			for (Produit p : prods)
			{
				System.out.println(p);
			} 
	}
	
	@Test
	public void testfindByNomPrix()
		 {
		List<Produit>  prods = produitRepository.findByNomPrix("PC Dell2", 2200.0);
			for (Produit p : prods)
				{
					System.out.println(p);
				}
			
		 }
	
	@Test
	public void testfindByCategorie()
	 {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);			
		List<Produit>  prods = produitRepository.findByCategorie(cat);
			for (Produit p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void findByCategorieIdCat()
		 {			
			List<Produit>  prods = produitRepository.findByCategorieIdCat(1L);
				for (Produit p : prods)
				{
					System.out.println(p);
				}
	       }
	
	@Test
	public void testfindByOrderByNomProduitAsc()
	 {
		List<Produit>  prods =    produitRepository.findByOrderByNomProduitAsc();	 
			for (Produit p : prods)
			{
				System.out.println(p);
			}
	 }
	
	@Test
	public void testTrierProduitsNomsPrix()
	 {
		List<Produit>  prods = produitRepository.trierProduitsNomsPrix();	 
			for (Produit p : prods)
			{
				System.out.println(p);
			}
	 }









	

}
