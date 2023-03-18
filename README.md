# BULKING-CUTTING
App

Uma API para controle de calorias consumidas e gastas

## Endpoints
*  Dados

    - cadastrar

    - mostrar

    - alterar

* Registro Calórico

  - Cadastrar

  - apagar

  - listar todas

  - Alterar

  - mostrar detalhes

  -----------  


## Cadastrar Dados /Altera Dados


  `POST`   /bulkingcutting/api/dados

  `P/api/daUT`   /bulkingcutting/api/dados/{id}

  

  **Campos da requisição**

 | Campo  | Tipo | Obrigatório  | Descrição|
| ------------- | ------------- | ------------- | ------------- | 
| id  | int  | sim  | Pk nome do Usuário   |
| nome  | String  | sim  | O nome do Usuário   |
| idade  | int  | sim  | a idade do usuário  |
| email  | String  | sim  | O email do Usuário   |
| senha  | String  | sim  | a senha do Usuário   |
| sexo_id  | int | sim  | o id previamente  cadastrado no sistema  |
|objetivo_id|int|sim|o id previamente  cadastrado no sistema  |
| peso  | float  | sim  | o peso do usuário(kg) |
| altura  | int  | sim  | a altura em cm   |

  **Exemplo de corpo de requisição**

```JS

{
 id:1 
 nome: "Fred Franklin ford",
 idade:32,
 email:"fred@gmail.com.br",
 senha:"mjshdkjs@44",
 sexo_id: 2,
 objetivo_id:1,
 peso:88.8,
 altura:188
}
```
**Respostas**


`POST`

| código| descrição
|-------|----------
| 201   | dados cadastrados com sucesso
| 400   | campos inválidos

`PUT`

| código| descrição
|-------|----------
| 200  | dados atualizados com sucesso
| 400   | campos inválidos

# Mostrar Detalhes Dados/GETALL


  `GET-ID`   /bulkingcutting/api/dados/{id}

  `GET-ALL`   /bulkingcutting/api/dados/

  


  **Exemplo de corpo de requisição**

```JS

{
 nome: "Fred Franklin ford",
 idade:32,
  sexo{
        sexo_id: 2,
        nome:"Masculino"
      }
  objetivo{
        sexo_id: 1,
        nome:"Perda de Peso"
        valor:"5"
      }
 sexo_id:2,
 objetivo_id:1,      
 peso:88.8,
 altura:188
}
```
**Respostas**

| código| descrição
|-------|----------
| 200   | dados retornados
| 404   | não existe dados para id informado


------------------------------------------------------------

## Cadastrar Registro Calórico/Altera Registro Calórico


  `POST`   /cuttingbulking/api/registrocalorico

  `PUT`   /cuttingbulking/api/registrocalorico/{id}



  

  **Campos da requisição**

 | Campo  | Tipo | Obrigatório  | Descrição|
| ------------- | ------------- | ------------- | ------------- | 
| tipo  | int  | sim  | o id previamente  cadastrado no sistema   |
| descricao  | String  | sim  | descrição ref. tipo  |
| data | date | sim  | data do registro  |
|calorias|float|sim| quantidade de calorias Kcal  |


  **Exemplo de corpo de requisição**

```JS

{
 tipo_id: 1,
 descricao:"Natação",
 data: 2023-06-03 11:59:32,
 caloria:128.85,
 
}
```
**Respostas**

`POST`

| código| descrição
|-------|----------
| 201   | registro calórico cadastrados com sucesso
| 400   | campos inválidos

`PUT`

| código| descrição
|-------|----------
| 200   | registro calórico  atualizado  com sucesso
| 400   | campos inválidos

# Mostrar Detalhes Registro Calórico /GETALL


  `GET`   /cuttingbulking/api/registrocalorico/{id}

  `GETALL`   /cuttingbulking/api/registrocalorico/

  


  **Exemplo de corpo de requisição**

```JS

{
  tipo{
    tipo_id:1
    nome:"Atividade"
  }
 tipo_id: 1,
 descrição:"Natação",
 data: 2023-06-03 11:59:32,
 caloria:128.85,
 
}
```
**Respostas**

| código| descrição
|-------|----------
| 200   | Registro Cálorico retornados
| 404   | não existe dados para id informado



# Apaga Registro Calórico



`DELETE`   /cuttingbulking/api/registrocalorico/{id}


| código| descrição
|-------|----------
| 204  | Registro Cálorico Deletado
| 404   | não existe dados para id informado



# Filtros Registros Calóricos

 **Filtro por Tipos de Atividades**

`GET`   /cuttingbulking/api/registrocalorico?tipo={id}


----------------------------------------------------------------

**Filtro por datas**
`GET`   /cuttingbulking/api/registrocalorico?data="today"

`GET`   /cuttingbulking/api/registrocalorico?data="yesterday"

`GET`   /cuttingbulking/api/registrocalorico?data="week"

`GET`   /cuttingbulking/api/registrocalorico?data="month"

`GET`   /cuttingbulking/api/registrocalorico?data="year"


     
