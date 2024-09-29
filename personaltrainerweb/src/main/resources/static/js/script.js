function gerarRotinaTreino(params) {
    let planoGerado = [];

    // Definindo os dados de entrada
    const { tipoTreino, nivelExperiencia, diasDisponiveis } = params;

    // Planos de treino Funcional
    const treinoFuncional = {
        iniciante: {
            1: ["Dia 1: Corrida 10min, Flexões 3x10"],
            3: ["Dia 1: Corrida 10min", "Dia 2: Agachamentos 3x15", "Dia 3: Abdominais 3x20"],
            5: ["Dia 1: Corrida 10min", "Dia 2: Flexões 3x10", "Dia 3: Agachamentos 3x15", "Dia 4: Burpees 3x10", "Dia 5: Corrida 10min"]
        }
        // Adicione outros níveis e tipos de treino conforme necessário
    };

    // Verifica o tipo de treino e preenche o planoGerado
    if (tipoTreino === "Funcional") {
        if (treinoFuncional[nivelExperiencia] && treinoFuncional[nivelExperiencia][diasDisponiveis]) {
            planoGerado = treinoFuncional[nivelExperiencia][diasDisponiveis];
        } else {
            return "Plano de treino não encontrado para os parâmetros fornecidos.";
        }
    }

    // Aqui você pode adicionar lógica semelhante para os outros tipos de treino (Cardio, Peso Livre, etc.)

    return planoGerado;
}

// Exemplo de uso da função
const params = {
    tipoTreino: "Funcional",
    nivelExperiencia: "iniciante",
    diasDisponiveis: 3
};

console.log(gerarRotinaTreino(params));