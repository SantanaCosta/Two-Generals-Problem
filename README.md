# Two Generals' Problem (Adapted)
Assignment for Discrete Mathematics (SI220) - 1st year of college.

<details>
  <summary>Problem description [PT-BR]</summary>
Há dois exércitos tentando atacar um castelo no centro de uma planície, O exército azul está ao sul e o exército vermelho está ao norte. A única possibilidade de vitória para os dois exércitos sobre o castelo é se eles atacarem ao mesmo tempo, para isso eles precisam sincronizar um horário para o ataque.

O exército vermelho comanda o exército azul, então ele deve enviar o primeiro mensageiro definindo a hora do ataque.

O exército vermelho dispõe de um sinalizador, ficou combinado entre os exércitos que quando o exército vermelho recebesse o mensageiro do exército azul confirmando o horário esse sinalizador seria disparado confirmando o ataque.

O exército Azul tem 1% de chance de impossibilitar o horário, levando o exército azul a enviar um mensageiro para solicitar um novo horário para o exército vermelho (quando o exercito vermelho receber o mensageiro do azul ele ira disparar o sinalizador, então volta pro vermelho denovo).

O mensageiro demora entre 60 ~ 70 minutos (3600 segundos ~ 4200 segundos) para atravessar o campo para enviar a mensagem.

O castelo captura cerca de 45% dos mensageiros.

Se após 210 Minutos e 1 segundo (12601 segundos) do envio do primeiro mensageiro do exército vermelho, o mensageiro do exército azul não chegar ao exército vermelho declara-se que o mensageiro enviado anteriormente morreu e é enviado outro. IMPORTANTE: Se o mensageiro do exército vermelho não morreu, quer dizer que os últimos 3 mensageiros do exército azul morreram, logo se há uma chance de que o quarto mensageiro do exército azul chegue no exército vermelho ao mesmo tempo que o do vermelho chegue no azul, se o exército vermelho ainda não tiver disparado o sinalizador quando o novo mensageiro chegar o exército azul deve enviar outro mensageiro.

Quando o Sinalizador for disparado (sem ser na impossibilidade) não há necessidade de enviar novos mensageiros.

Se após 70 minutos e 1 segundo (4201 segundos) do envio do mensageiro do exército azul não for observado o disparo do sinalizador ou não receber um novo mensageiro definindo um novo horário, o exército azul declara que o ultimo mensageiro morreu e deve enviar um novo.
Cada exército só pode enviar um mensageiro por vez.

O exército vermelho dispõe de 5 mensageiros, e o azul dispõe de 10 mensageiros.

Se esgotar o número de mensageiros de um exército antes do sinalizador ter sido disparado o exército perde.

O seu algoritmo deve exibir a timestamp de início da troca de mensagens, e a suposta timestamp de termino da troca de mensagens (Adicione os valores da viagem dos mensageiros).

O algoritmo deve exibir quanto tempo demorou a troca de mensagens(hh:mm:ss), quantos mensageiros foram utilizados de cada exército e se o exército perdeu a batalha.
Deve-se utilizar um gerador randômico para o tempo de travessia do mensageiro, para a possibilidade de o castelo capturar um mensageiro e para a possibilidade do exército azul impossibilitar o horário escolhido pelo exército vermelho.
</details>

## Screenshots
![1](https://github.com/SantanaCosta/Two-Generals-Problem/assets/106698124/59f34609-bdb7-49d2-8004-2d04dc88c91b)
![2](https://github.com/SantanaCosta/Two-Generals-Problem/assets/106698124/12477454-506a-4cc1-930e-45613d14fd63)
![3](https://github.com/SantanaCosta/Two-Generals-Problem/assets/106698124/b0bcdfcf-a6f5-4e70-9dff-0a1b1c835912)
![4](https://github.com/SantanaCosta/Two-Generals-Problem/assets/106698124/92193ab7-3d9a-46d5-a52e-5c17acb14e7d)



