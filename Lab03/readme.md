# Lab03 - Classes com atributos *final*, uso de *ArrayList* e Herança

## Objetivo
Familiarização a construção de classes que possuam atributosfinal, além do uso de ArrayList e Herança.

## Atividade
Continuação do laboratório anterior adicionando novas classes: Grupo, GrupoPublico, GrupoPrivado e Admin.

### Classe Usuario
Responsável por armazenar os dados únicos de acesso do usuário ao sistema.
#### Estrutura da classe Usuario
##### Atributos
- _id_ : int
- _login_: String
- _email_: String
- _senha_: String
- _dataAtavacao_ : GregorianCalendar
- _satus_: boolean
##### Funções
- _toString_: String

### Classe Perfil
Responsável por armazenar os dados que caracterizam o perfil de um usuário do sistema.
#### Estrutura da classe Perfil
##### Atributos
- _sexo_: char
- _dataNascimento_: GregorianCalendar
- _cidade_: String
- _estado_: String
- _telefone_: String
- _descricao_: String
- _foto_: String
##### Funções
- _toString_: String

### Classe Sala
#### Estrutura da classe Sala
##### Atributos
- _numeroSalas_: static int
- _id_: static int
- _capacidadeMaxima_: int
- _numeroUsuarios_: int
- _descricao_: String
- _dono_: Usuario
- _ingressoAutomatico_:  boolean
- _dataCriacao_: GregorianCalendar
##### Funções
- _toString()_: String
- _adiciona()_: boolean
- _removeUsuario()_: boolean
- _getNumeroSalas():_ static int

### Classe Cartao
#### Estrutura da classe Cartao
##### Atributos
- _numeroCartoes_: static int
- _id_: static int
- _visibilidade_: int
- _nome_: String
- _dono_: Usuario
- _invitationOnly_:  boolean
- _dataCriacao_: GregorianCalendar
##### Funções
- _toString()_: String
- _getNumeroCartoes()_: static int

### Classe Grupo
Classe mãe de GrupoPublico e GrupoPrivado.
#### Estrutura da classe Grupo
##### Atributos
- _id_ : int
- _nome_: String
- _descricao_: String
- _dono_: final Usuario
- _satus_: boolean
- _dataCriacao_ : GregorianCalendar
##### Funções
- _toString_: String

### Classe GrupoPublico
Herdeira de Grupo e visível para todos os usuários.
#### Estrutura da classe GrupoPublico
##### Atributos
- mesmos de Grupo
- _membros[]_: Usuario
##### Funções
- _toString_: String
- _adicionaMembro(Usuario)_
- _removeMembro(Usuario)_

### Classe GrupoPrivado
Herdeira de Grupo e não é visível para todos.
#### Estrutura da classe GrupoPrivado
##### Atributos
- mesmos de Grupo
- _membros[]_: Usuario
##### Funções
- _toString_: String
- _adicionaMembro(Usuario)_
- _removeMembro(Usuario)_

### Classe Admin
Herdeira de Usuario que pode desabilitar grupos.
#### Estrutura da classe Admin
##### Atributos
- mesmos de Usuario
##### Funções
- _desabilitarGrupo()_

## Classe Main
### Classe Usuario
- 4 objetos criados
### Classe Admin
- 1 objeto criados
### Classe GrupoPublico
- 1 objeto criado
- 2 membros adicionados
### Classe GrupoPrivado
- 1 objeto criado
- 2 membros adicionados
### Demonstrações presentes na Main
- O dono de um grupo não pode ser alterado
- Apenas um admin pode mudar o status de um grupo
- Apenas o dono de um grupo privado pode inserir ou remover usuários


## Questões do lab
Na main se encontram as respostas para as seguintes perguntas:
1. Tente modificar o valor da dono de um grupo (que é um atributo final). Crie um setter se necessário. Foi possível fazer a modificação? Explique.
2. Agora, no método main, crie uma variável final do tipo Grupo, e instancie ela com os valores que preferir. Tente modificar algum atributo do objeto através de um setter, como o atributo referente ao id. Foi possível modificar esse atributo, mesmo com o objeto sendo final? Por quê?
3. Se ao invés de usar ArrayList para definir a lista de membros da classe Grupo tivéssemos usado um array, o que mudaria na implementação? Poderíamos continuar adicionado membros como fizemos? Haveria alguma limitação? Discuta as desvantagens dessa solução.
4. Qual o principal benefício da herança?
5. Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de Grupo ser final e se definirmos GrupoPublico como final?
6. Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe mãe (Grupo)?
