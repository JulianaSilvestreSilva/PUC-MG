#include <iostream>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>
#define MAX 100

using namespace std;

class Pessoa{
    private:
        string nome;
        int diaDeNascimento;
        int mesDeNascimento;

    public:
        static int quantidade;

        Pessoa(){
            quantidade++;
        }
        Pessoa(string nome, int dia, int mes){
            SetNome(nome);
            setDiaNascimento(dia);
            setMesNascimento(mes);
            quantidade++;

        }
        ~Pessoa(){
            quantidade--;
        }
        void SetNome(string nome){
            this->nome = nome;
        }
        string getNome(){
            return this->nome;
        }

        void setDiaNascimento(int dia){
            if(dia>31 || dia<1) this->diaDeNascimento = 0;
            else this->diaDeNascimento = dia;
        }
        int getDiaNascimento(){
            return this->diaDeNascimento;
        }

        void setMesNascimento(int mes){
            if(mes>12 || mes<1) this->mesDeNascimento = 0;
            else this->mesDeNascimento = mes;
        }
        int getMesNascimento(){
            return this->mesDeNascimento;
        }

        virtual void le()=0;

        virtual void escreve(){
            cout<<"\nNome: "<< this->getNome();
            cout<<"\nDia de nascimento: "<< this->getDiaNascimento();
            cout<<"\nMes de nascimento: "<< this->getMesNascimento();
        }
        bool aniversarianteMes(int mes){
            bool ehAniversariante=true;
            if(this->getMesNascimento() != mes)ehAniversariante=false;
            return ehAniversariante;
        }

};
class Cliente : public Pessoa{
    private:
        float limiteCredito;
    public:
        static int quantidade;
        Cliente(){
            quantidade++;
        }
        ~Cliente(){
            quantidade--;
        }
        void setLimite(float limiteCredito){
            this->limiteCredito = limiteCredito;
        }
        float getLimite(){
            return this->limiteCredito;
        }
        virtual void le(){
            string nome;
            int dia;
            int mes;
            cout << "\nNome:";
            cin >> nome;
            cout << "\nDia de nascimento:";
            scanf("%i", &dia);
            cout << "\nMes de nascimento:";
            scanf("%i", &mes);
            SetNome(nome);
            setDiaNascimento(dia);
            setMesNascimento(mes);
            float limite;
            cout << "\nLimite: ";
            cin >> limite;
            setLimite(limite);
        }
        virtual void escreve(){
            Pessoa::escreve();
            cout << "\nLimite: " << getLimite();
        }
        bool creditoAprovado(float valorCompra){
            bool aprovado = true;
            if(valorCompra > limiteCredito)aprovado=false;
            return aprovado;
        }
};

class Funcionario : public Pessoa{
    private:
        float salarioBruto;
    public:
        static int quantidade;
        Funcionario(){
            quantidade++;
        }
        ~Funcionario(){
            quantidade--;
        }
        void setSalario(float salario){
            this->salarioBruto = salario;
        }
        float getSalario(){
            return this->salarioBruto;
        }
        virtual void le(){
            string nome;
            int dia;
            int mes;
            cout << "\nNome:";
            cin >> nome;
            cout << "\nDia de nascimento:";
            scanf("%i", &dia);
            cout << "\nMes de nascimento:";
            scanf("%i", &mes);
            SetNome(nome);
            setDiaNascimento(dia);
            setMesNascimento(mes);
            float salario;
            cout << "\nSalario: ";
            cin >> salario;
            setSalario(salario);
        }
        virtual void escreve(){
            Pessoa::escreve();
            cout << "\nSalario: " << getSalario();
        }
        float salarioLiquido(){
            return salarioBruto - (salarioBruto*8/100);
        }
        float salarioLiquido(float percentual){
            return salarioBruto - (salarioBruto * percentual/100);
        }
};

int Pessoa::quantidade=0;
int Cliente::quantidade=0;
int Funcionario::quantidade=0;

int menu()
{
    int opcao;
    cout << "\n\n 0 - Sair do programa";
    cout << "\n 1 - Pessoa: listar todas as pessoas";
    cout << "\n 2 - Pessoa: pesquisar por aniversariante do mes";
    cout << "\n 3 - Cliente: cadastrar";
    cout << "\n 4 - Cliente: consultar aprovacao";
    cout << "\n 5 - Cliente: listar todos os clientes";
    cout << "\n 6 - Funcionario: cadastrar";
    cout << "\n 7 - Funcionario: calcular salario";
    cout << "\n 8 - Funcionario: listar todos funcionarios";

    cout << "\n sua opcao: ";
    cin >> opcao;
    return opcao;
}

int main()
{
    cout << "projeto final!" << endl;

    Pessoa* pessoa[2*MAX];
    Cliente* cliente[MAX];
    Funcionario* funcionario[MAX];
    int opcao;

    do{
        opcao = menu();
        if(opcao==0)cout << "\nObrigado por usar esse programa!";
        else if(opcao==1){
            for(int cont=1; cont<=Pessoa::quantidade; cont++){
                pessoa[cont]->Pessoa::escreve();
            }
        }
        else if(opcao==2){
            int mes;
            do{
                cout<<"\ndigite o mes de pesquisa:";
                cin >> mes;
                if(mes>12 || mes<1)cout<<"\n\ames invalido!";
            }while(mes>12 || mes<1);
            for(int cont=0; cont<=Pessoa::quantidade; cont++){
                if(pessoa[cont]->aniversarianteMes(mes))pessoa[cont]->Pessoa::escreve();
            }
        }
        else if(opcao==3){
            bool erro = Cliente::quantidade==MAX;
            try{
                if(!erro){
                    cliente[Cliente::quantidade] = new Cliente();
                    cliente[Cliente::quantidade]->le();
                    pessoa[Pessoa::quantidade] = cliente[Cliente::quantidade];

                }
                else throw(erro);
            }
            catch(bool erro){
                cout<<"\nFaltou memoria";
            }
        }
        else if(opcao==4){
            float valor;
            cout << "\nValor da compra: ";
            cin >> valor;
            int numCliente;
            cout <<"\nQual cliente? "; //deve ser digitado o numero correspondende ao cliente (o primeiro cliente cadastrado corresponde ao numero 1 e assim por diante)
            cin >> numCliente;
            if(cliente[numCliente]->creditoAprovado(valor))cout <<"\nCredito aprovado";
            else cout << "\nCredito nao aprovado";
        }
        else if(opcao==5){
            for(int cont=1; cont<=Cliente::quantidade; cont++){
                cliente[cont]->escreve();
            }
        }
        else if(opcao==6){
            bool erro = Funcionario::quantidade==MAX;
            try{
                if(!erro){
                    funcionario[Funcionario::quantidade] =  new Funcionario();
                    funcionario[Funcionario::quantidade]->le();
                    pessoa[Pessoa::quantidade]= funcionario[Funcionario::quantidade];

                }
                else throw(erro);
            }
            catch(bool erro){
                cout<<"\nFaltou memoria";
            }
        }
        else if(opcao==7){
            string resposta;
            cout << "\nDeseja informar percentual de INSS? [sim/nao]: ";
            cin >> resposta;
            int numFuncionario;
            cout <<"\nQual Funcionario? "; //deve ser digitado o numero correspondende ao funcionario (o primeiro funcionario cadastrado corresponde ao numero 1 e assim por diante)
            cin >> numFuncionario;
            float salario;
            if(resposta == "sim"){
                float percentual;
                cout << "\nPercentual: ";
                cin >> percentual;
                salario = funcionario[numFuncionario]->salarioLiquido(percentual);
                cout << "\n Salario Liquido: " << salario;
            }
            else {
                salario = funcionario[numFuncionario]->salarioLiquido();
                cout << "\n Salario Liquido: "<< salario;
            }
        }
        else if(opcao==8){
            for(int cont=1; cont<=Funcionario::quantidade; cont++){
                funcionario[cont]->escreve();
            }
        }

        }while(opcao!=0);


    return 0;
}
