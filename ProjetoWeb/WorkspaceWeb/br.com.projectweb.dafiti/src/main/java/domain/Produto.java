package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
	//Integer aceita null, Int recebe 0;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	@Column(length = 50, nullable = false, unique = true)
	private String nome;
	@Column(nullable = false)
	private Integer quantidade;
	@Column
	private String genero;
	// Double aceita null
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;
	// LocalDate-Datas, LocalTime-Horas, LocalDateTime-Data e Hora
	@Column
	private LocalDate dataDeValidade;
	@ManyToOne
	@JoinColumn(nullable = false)// Se for @OneToOne precisa colocar UNIQUE
	private Categoria categoria; 
}
