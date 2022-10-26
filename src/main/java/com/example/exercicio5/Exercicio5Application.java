package com.example.exercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.exercicio5.entities.Student;
import com.example.exercicio5.entities.Test;

@SpringBootApplication
public class Exercicio5Application {
	public static void main(String[] args) {
		SpringApplication.run(Exercicio5Application.class, args);
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String firstMenu = "";

		List<Student> students = new ArrayList<>();

		do {
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("1. Cadastrar aluno");
			System.out.println("2. Listar alunos");
			System.out.println("3. Ver maior nota");
			System.out.println("\nS. Sair");
			firstMenu = sc.nextLine();

			if (firstMenu.equals("1")) {
				System.out.print("\nDigite o nome do Aluno: ");
				Student student = new Student(null, sc.nextLine());
				students.add(student);
			} else if (firstMenu.equals("2")) {
				String menuStudents = "";
				System.out.println("\nAlunos: ");
				int qtOfStudents = 1;
				for (Student s : students) {
					System.out.println(qtOfStudents + ". " + s.getName());
					qtOfStudents++;
				}
				System.out.println("\nV. Voltar");
				System.out.println("S. Sair");

				menuStudents = sc.nextLine();
				if (menuStudents.equalsIgnoreCase("S")) {
					break;
				} else if (menuStudents.equalsIgnoreCase("V")) {
					continue;
				} else {
					try {
						/*
						 * Aqui entra o código de calculos de média, maior nota, menor nota e quantidade
						 * de provas realizadas. Será realizada uma consulta sql
						 * 
						 */
						String menuTests = "";
						int index = Integer.parseInt(menuStudents);
						index--;
						System.out.println("Aluno: " + students.get(index).getName());
						System.out.println("Média: " + String.format("%.2f", 0F));
						System.out.println("Maior nota: " + String.format("%.2f", 0F));
						System.out.println("Menor nota: " + String.format("%.2f", 0F));
						System.out.println("Provas realizadas: " + 0);

						System.out.println("\n1. Cadastrar Prova para este aluno");

						System.out.println("\nV. Voltar");
						System.out.println("S. Sair");

						menuTests = sc.nextLine();

						if (menuTests.equalsIgnoreCase("S")) {
							break;
						} else if (menuTests.equalsIgnoreCase("V")) {
							continue;
						} else {
							try {
								System.out.print("Digite a nota da prova: ");
								Test test = new Test(null,sc.nextDouble());
								students.get(index).addTest(test);
								System.out.println("Teste adicionado com sucesso! ");
							} catch (Exception e) {
								System.out.println("ERRO! Entrada de nota inválida!");
							}
						}
					} catch (Exception e) {
						System.out.println("ERRO! Opção digitada inválida!" + e.getMessage());
						continue;
					}
				}
			} else if (firstMenu.equals("3")) {
				/*
				 * Codigo para buscar a maior nota realizado em pesquisa sql
				 */

			} else if (firstMenu.equalsIgnoreCase("s")) {
				break;
			} else {
				System.out.println("ERRO! Opção digitada inválida!\n");
			}
			System.out.println("\n");
		} while (!firstMenu.equalsIgnoreCase("S"));
		System.out.println("Fim da aplicação!");
		sc.close();
	}

}
