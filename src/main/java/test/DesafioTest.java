package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import bodyFactory.BodyFactory;
import core.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DesafioTest extends BaseTest{



	@Test
	public void Test_01_buscaPostsEspecificoComSucesso() {
		given()
		.when()
		.get("/posts/1")
		.then()
		.statusCode(200)
		.body("userId", is(1))
		.body("id", is(1))
		.body("title", is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
		.body("body", is("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
		;
	}

	@Test
	public void Test_02_cadastrarPostComSucesso() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("sucesso").toString())
		.when()
		.post("/posts/")
		.then()
		.statusCode(201)
		.body("title", is("Titulo Desafio Teste"))
		.body("body", is("Body Desafio Teste"))
		.body("userId", is("65"))
		.body("id", is(101))
		;
	}

	@Test
	public void Test_03_cadastrarPostSemInformarTitulo() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("tituloVazio").toString())
		.when()
		.post("/posts/")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_04_cadastrarPostSemInformarBody() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("bodyVazio").toString())
		.when()
		.post("/posts/")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_05_cadastrarPostSemInformarId() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("idVazio").toString())
		.when()
		.post("/posts/")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_06_cadastrarPostSemMandarBodyDaRequisicao() throws IOException, Exception {
		given()
		.when()
		.post("/posts/")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_07_atualilzarCadastroPostComSucesso() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("sucesso").toString())
		.when()
		.put("/posts/1")
		.then()
		.statusCode(200)
		.body("title", is("Titulo Desafio Teste"))
		.body("body", is("Body Desafio Teste"))
		.body("userId", is("65"))
		.body("id", is(1))
		;
	}

	@Test
	public void Test_08_atualilzarCadastroPostParametroInvalido() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("sucesso").toString())
		.when()
		.put("/posts/tttt")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_09_atualilzarCadastroPostSemPassarParametro() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("sucesso").toString())
		.when()
		.put("/posts/")
		.then()
		.statusCode(404)
		;
	}

	@Test
	public void Test_10_atualilzarApenasUmDadoDpCadastroPostComSucesso() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("atualizaTitulo").toString())
		.when()
		.patch("/posts/1")
		.then()
		.statusCode(200)
		.body("title", is("Titulo Desafio Teste"))
		.body("body", is("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"))
		.body("userId", is(1))
		.body("id", is(1))
		;
	}

	@Test
	public void Test_11_atualilzarApenasUmDadoDoCadastroPostParametroInvalido() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("atualizaTitulo").toString())
		.when()
		.patch("/posts/tttttt")
		.then()
		.statusCode(400)
		;
	}

	@Test
	public void Test_12_atualilzarApenasUmDadoDpCadastroPostSemPassarParametro() throws IOException, Exception {
		given()
		.body(BodyFactory.bodyPosts("atualizaTitulo").toString())
		.when()
		.patch("/posts/")
		.then()
		.statusCode(404)
		;
	}

	@Test
	public void Test_13_deletarCadastroPost() throws IOException, Exception {
		given()
		.when()
		.delete("/posts/1")
		.then()
		.statusCode(200)
		;
	}

	@Test
	public void Test_14_deletarCadastroPostSemPassarParametro() throws IOException, Exception {
		given()
		.when()
		.delete("/posts/")
		.then()
		.statusCode(404)
		;
	}

	@Test
	public void Test_14_deletarCadastroPostPassandoParametroInvalido() throws IOException, Exception {
		given()
		.when()
		.delete("/posts/ttttt")
		.then()
		.statusCode(404)
		;
	}


}
