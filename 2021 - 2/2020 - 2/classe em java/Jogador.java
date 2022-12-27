class Jogador{ //declarando os atributos privados
	private static int id;
	private static String nome;
	private static int altura;
	private static int peso;
	private static String universidade;
	private static int anoNascimento;
	private static String cidadeNascimento;
	private static String estadoNascimento;
	
	public static void Jogador(){ //metodo construtor vazio
	}
	public static void Jogador(int cont){ //metodo costrutor que armazena a quantidade de instancias criadas
		cont++;
	}
	public static void setId(Jogador jogador, String csv, int posicao){ //inicio dos metodos set 
		String id = "";
		int i=0;
		while(csv.charAt(i)!= ','){
			id+=csv.charAt(i);
			i++;
		}
		jogador.id = Integer.parseInt(id);

	}
	public static void setNome(Jogador jogador, String csv, int posicao){
		String nome = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){ //percorre a string identificando as virgulas para separar o conteudo de cada atributo 
			if(csv.charAt(j)==','){ 
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==1){
			    i=posVirgula+1;
			    while(virgula<2){
				if(csv.charAt(i)==',') virgula++;
				 else {
					nome+=csv.charAt(i);
					i++;
				}
			    }
			    j=csv.length();
			}
		}
		jogador.nome = nome;
	}
	public static void setAltura(Jogador jogador, String csv, int posicao){
		String altura = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==2){
			    i=posVirgula+1;
			    while(virgula<3){
				if(csv.charAt(i)==',') virgula++;
				 else {
					altura+=csv.charAt(i);
					i++;
				}
			    }
			    j=csv.length();
			}
		}
		jogador.altura = Integer.parseInt(altura);
	}
	public static void setPeso(Jogador jogador, String csv, int posicao){
		String peso = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==3){
			    i=posVirgula+1;
			    while(virgula<4){
				if(csv.charAt(i)==',') virgula++;
				 else {
					peso+=csv.charAt(i);
					i++;
				}
			    }
			    j=csv.length();
			}
		}
		jogador.peso = Integer.parseInt(peso);
	}
	public static void setColegio(Jogador jogador, String csv, int posicao){
		String colegio = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==4){
			    i=posVirgula+1;
			    
				if(csv.charAt(i)==','){
					 colegio = "nao informado";
					 virgula++;
				 }
				 else {
					while(csv.charAt(i)!=','){
					colegio+=csv.charAt(i);
					i++;
					}
				}
			    
			    j=csv.length();
			}
		}
		jogador.universidade = colegio;
	}
	public static void setAno(Jogador jogador, String csv, int posicao){
		String ano = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==5){
			    i=posVirgula+1;
			    while(virgula<6){
				if(csv.charAt(i)==',') virgula++;
				 else {
					ano+=csv.charAt(i);
					i++;
				}
			    }
			    j=csv.length();
			}
		}
		jogador.anoNascimento = Integer.parseInt(ano);
	}
	public static void setCidade(Jogador jogador, String csv, int posicao){
		String cidade = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==6){
			    i=posVirgula+1;
			    
				if(csv.charAt(i)==','){
					 cidade = "nao informado";
					 virgula++;
				 }
				 else {
					while(csv.charAt(i)!=','){
					cidade+=csv.charAt(i);
					i++;
					}
				}
			    
			    j=csv.length();
			}
		}
		jogador.cidadeNascimento = cidade;
	}
	public static void setEstado(Jogador jogador, String csv, int posicao){
		String estado = "";
		int virgula = 0;
		int i=0;
		int posVirgula = 0;
		int tamanho = csv.length();
		for(int j=0; j<csv.length(); j++){
			if(csv.charAt(j)==','){
			    virgula++;
			    posVirgula=j;
			}
			if(virgula==7){
			    i=posVirgula;
			    if(i==tamanho-1) estado = "nao informado";
			    else{
			    i++;
			    do{
				estado+=csv.charAt(i);
				i++;
			    }while(i<=tamanho-1);
			}
			    j=csv.length();
			}
		}
		jogador.estadoNascimento = estado;
	} //fim dos metodos set

	public static int getId(Jogador jogador) //inicio dos metodos get que retornam o valor dos atributos de jogador
	{
	    return jogador.id;
	}
	public static String getNome(Jogador jogador)
	{
	    return jogador.nome;
	}
	public static int getAltura(Jogador jogador)
	{
	    return jogador.altura;
	}
	public static int getPeso(Jogador jogador)
	{
	    return jogador.peso;
	}
	public static String getUniversidade(Jogador jogador)
	{
	    return jogador.universidade;
	}
	public static int getAno(Jogador jogador)
	{
	    return jogador.anoNascimento;
	}
	public static String getCidade(Jogador jogador)
	{
	    return jogador.cidadeNascimento;
	}
	public static String getEstado(Jogador jogador)
	{
	    return jogador.estadoNascimento;
	} //fim dos metodos get

	public static void clone(Jogador jogador, String csv, int posicao){ //metodo que clona um jogador
		Jogador jogadorClone = new Jogador();
		jogadorClone = jogador;
		setId(jogador,csv, posicao);
		setNome(jogador, csv, posicao);
		setAltura(jogador, csv, posicao);
		setPeso(jogador, csv, posicao);
		setColegio(jogador, csv, posicao);
		setAno(jogador, csv, posicao);
		setCidade(jogador, csv, posicao);
		setEstado(jogador, csv, posicao);
		
	}
	public static void imprimir(Jogador jogador){
		MyIO.println("["+getId(jogador)+" ## "+getNome(jogador)+" ## "+getAltura(jogador)+" ## "+getPeso(jogador)+" ## "+getAno(jogador)+" ## "+getUniversidade(jogador)+" ## "+getCidade(jogador)+" ## "+getEstado(jogador)+"]");

	}
	public static void le(Jogador jogador, String csv){ //leitura da linha do arquivo e chamada dos metodos set
		int posicao=0;
		setId(jogador,csv, posicao);
		setNome(jogador, csv, posicao);
		setAltura(jogador, csv, posicao);
		setPeso(jogador, csv, posicao);
		setColegio(jogador, csv, posicao);
		setAno(jogador, csv, posicao);
		setCidade(jogador, csv, posicao);
		setEstado(jogador, csv, posicao);
		posicao++;
		imprimir(jogador);
	}
	public static void main(String[] args)throws Exception {
	
		String leitura = MyIO.readLine();
		boolean fim=false;

		int id;
		do{
			Arq.openRead("/tmp/players.csv");
			String primeiraLinha = Arq.readLine(); //primeira linha do arquivo nao deve ser considerada na resposta

			if(leitura.charAt(0)=='F')fim=true;
			else 
			{		
			id = Integer.parseInt(leitura);
			int cont=0;

			while(cont<=id){
				String csv = Arq.readLine();
				if(cont==id){
					Jogador jogador = new Jogador();
					le(jogador,csv);
				}
				cont++;
			}
			Arq.close();
			leitura=MyIO.readLine();
			}
		}while(fim==false);

	}

}
