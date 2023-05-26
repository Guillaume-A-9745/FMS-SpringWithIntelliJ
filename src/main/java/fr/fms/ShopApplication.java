package fr.fms;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication implements CommandLineRunner {

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateData();
	}

	//Alimenter la base de donnée
	private void generateData() {
		Category samrtphone = categoryRepository.save(new Category(null,"Smartphone",null));
		Category pc = categoryRepository.save(new Category(null,"Ordinateur",null));
		Category tablet = categoryRepository.save(new Category(null,"Tablette",null));
		Category printer = categoryRepository.save(new Category(null,"Imprimante",null));
		Category camera = categoryRepository.save(new Category(null,"Camera",null));
		Category tv = categoryRepository.save(new Category(null,"TV",null));
		Category telescope = categoryRepository.save(new Category(null,"Telescope",null));
		Category gps = categoryRepository.save(new Category(null,"Gps",null));
		Category enceinte = categoryRepository.save(new Category(null,"Enceinte",null));



		articleRepository.save(new Article(null,"Samsung S8",250, samrtphone));
		articleRepository.save(new Article(null,"Samsung S9", 300, samrtphone));
		articleRepository.save(new Article(null,"Iphone 10",500, samrtphone));
		articleRepository.save(new Article(null,"Xiaomi MI11",100, samrtphone));
		articleRepository.save(new Article(null,"OnePlus 9 Pro",200, samrtphone));
		articleRepository.save(new Article(null,"Google Pixel 5",350, samrtphone));
		articleRepository.save(new Article(null,"Poco F3",150, samrtphone));

		articleRepository.save(new Article(null,"Dell 810",550, pc));
		articleRepository.save(new Article(null,"Asus F756",600, pc));
		articleRepository.save(new Article(null,"Asus E80",700, pc));
		articleRepository.save(new Article(null,"MacBook Pro",1000, pc));
		articleRepository.save(new Article(null,"MacBook Air",1200, pc));

		articleRepository.save(new Article(null,"IPad XL 5",300, tablet));
		articleRepository.save(new Article(null,"IPad XL 7",500, tablet));


		articleRepository.save(new Article(null,"Canon MG30",50, printer));
		articleRepository.save(new Article(null,"Canon MG50",60, printer));
		articleRepository.save(new Article(null,"HP 800",50, printer));
		articleRepository.save(new Article(null,"Epson 3T",100, printer));

		articleRepository.save(new Article(null,"GoPro 7",150, camera));
		articleRepository.save(new Article(null,"GoPro 10",200, camera));

		articleRepository.save(new Article(null,"Panasonic HT",1500, tv));
		articleRepository.save(new Article(null,"Philips L43",450, tv));

	}
}
