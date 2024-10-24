function gerarRotinaTreino(params) {
    let planoGerado = [];

    // Planos de treino Funcional
    const treinoFuncional = {
        iniciante: {
            1: ["Dia 1: Esteira ou Bike 15min, Flexões 3x10", "Pular Corda 5min, Abdominais 3x20", "Agachamentos 3x15", "Burpees 3x10", "Esteira ou Bike 15min"],
            3: ["Dia 1: Esteira ou Bike 15min, Pular Corda 5min", "Dia 2: Agachamentos 3x15, Flexões 3x10", "Dia 3: Abdominais 3x20, Burpees 3x10"],
            5: ["Dia 1: Esteira ou Bike 15min, Flexões 3x10", "Dia 2: Pular Corda 5min, Abdominais 3x20", "Dia 3: Agachamentos 3x15", "Dia 4: Burpees 3x10, Pular Corda 5min", "Dia 5: Esteira ou Bike 15min"]
        },
        intermediário: {
            1: ["Dia 1: Esteira ou Bike 20min, Flexões 4x15", "Pular Corda 10min, Abdominais 4x25", "Agachamentos 4x20", "Burpees 4x15", "Esteira ou Bike 20min"],
            3: ["Dia 1: Esteira ou Bike 20min, Pular Corda 10min", "Dia 2: Agachamentos 4x20, Flexões 4x15", "Dia 3: Abdominais 4x25, Burpees 4x15"],
            5: ["Dia 1: Esteira ou Bike 20min, Flexões 4x15", "Dia 2: Pular Corda 10min, Abdominais 4x25", "Dia 3: Agachamentos 4x20", "Dia 4: Burpees 4x15", "Dia 5: Esteira ou Bike 20min"]
        },
        avançado: {
            1: ["Dia 1: Esteira ou Bike 30min, Flexões 5x20", "Pular Corda 15min, Abdominais 5x30", "Agachamentos 5x20", "Burpees 5x20", "Esteira ou Bike30min"],
            3: ["Dia 1: Esteira ou Bike 30min, Pular Corda 15min", "Dia 2: Agachamentos 5x20, Flexões 5x20", "Dia 3: Abdominais 5x30, Burpees 5x20"],
            5: ["Dia 1: Esteira ou Bike 30min, Flexões 5x20", "Dia 2: Pular Corda 15min, Abdominais 5x30", "Dia 3: Agachamentos 5x20", "Dia 4: Burpees 5x20", "Dia 5: Esteira ou Bike 30min"]
        }
    };

    // Planos de treino Cardio
    const treinoCardio = {
        iniciante: {
            1: ["Dia 1: Esteira ou Bike 15min, Pular Corda 10min"],
            3: ["Dia 1: Esteira ou Bike 15min", "Dia 2: Pular Corda 10min", "Dia 3: Esteira ou Bike 15min"],
            5: ["Dia 1: Esteira ou Bike 15min", "Dia 2: Pular Corda 10min", "Dia 3: Esteira ou Bike 15min", "Dia 4: Pular Corda 10min", "Dia 5: Esteira ou Bike 15min, Pular Corda 10min "]
        },
        intermediário: {
            1: ["Dia 1: Esteira 20min, Pular Corda 15min"],
            3: ["Dia 1: Esteira 20min", "Dia 2: Pular Corda 15min", "Dia 3: Esteira ou Bike 20min"],
            5: ["Dia 1: Esteira 20min", "Dia 2: Pular Corda 15min", "Dia 3: Esteira ou Bike 20min", "Dia 4: Pular Corda 15min", "Dia 5: Esteira ou Bike 20min"]
        },
        avançado: {
            1: ["Dia 1: Esteira ou Bike 30min, Pular Corda 20min"],
            3: ["Dia 1: Esteira ou Bike 30min", "Dia 2: Pular Corda 20min", "Dia 3: Esteira ou Bike 30min"],
            5: ["Dia 1: Esteira ou Bike 30min", "Dia 2: Pular Corda 20min", "Dia 3: Esteira ou Bike 30min", "Dia 4: Pular Corda 20min", "Dia 5: Esteira ou Bike 30min"]
        }
    };

    // Planos de treino Peso Livre
    const treinoPesoLivre = {
        iniciante: {
            1: [
                "Dia 1:",
                "Peito: Supino reto 3x12, Flexões 3x15",
                "Tríceps: Tríceps banco 3x12",
                "Costas: Puxada na polia 3x12",
                "Bíceps: Rosca direta 3x12",
                "Pernas: Agachamento 3x15",
                "Abdômen: Abdominais 3x20",
                "Ombros: Elevação lateral 3x12",
                "Cardio: Esteira ou Bike 15min"
            ],
            3: [
                "Dia 1: Peito e Tríceps",
                "Peito: Supino reto 3x12, Flexões 3x15",
                "Tríceps: Tríceps banco 3x12",
                "Dia 2: Costas, Bíceps e Ombros",
                "Costas: Puxada na polia 3x12, Remada curvada 3x12",
                "Bíceps: Rosca direta 3x12",
                "Ombros: Elevação lateral 3x12, Desenvolvimento militar 3x12",
                "Dia 3: Pernas, Abdômen e Cardio",
                "Pernas: Agachamento 3x15, Leg press 3x12",
                "Abdômen: Abdominais 3x20",
                "Cardio: Esteira ou Bike 15min"
            ],
            5: [
                "Dia 1: Peito e Cardio",
                "Peito: Supino reto 3x12, Flexões 3x15",
                "Cardio: Esteira ou Bike 15min",
                "Dia 2: Costas",
                "Costas: Remada curvada 4x12, Puxada na polia 3x12",
                "Dia 3: Pernas",
                "Pernas: Agachamento 3x15, Leg press 3x12",
                "Dia 4: Ombros e Tríceps",
                "Ombros: Desenvolvimento militar 3x12, Elevação lateral 3x12",
                "Tríceps: Tríceps banco 3x12",
                "Dia 5: Abdômen e Bíceps",
                "Abdômen: Abdominais 3x20",
                "Bíceps: Rosca direta 3x12",

            ]
        },

        intermediário: {
            1: [
                "Dia 1:",
                "Peito: Supino reto 4x10, Flexões 4x12",
                "Tríceps: Tríceps banco 4x10",
                "Costas: Puxada na polia 4x10",
                "Bíceps: Rosca direta 4x10",
                "Pernas: Agachamento 4x12",
                "Abdômen: Abdominais 4x25",
                "Ombros: Elevação lateral 4x10",
                "Cardio: Esteira ou Bike 20min"
            ],
            3: [
                "Dia 1: Peito e Tríceps",
                "Peito: Supino reto 4x10, Flexões 4x12",
                "Tríceps: Tríceps banco 4x10",
                "Dia 2: Costas, Bíceps e Ombros",
                "Costas: Puxada na polia 4x10, Remada curvada 3x12",
                "Bíceps: Rosca direta 4x10",
                "Ombros: Elevação lateral 4x10, Desenvolvimento militar 4x10",
                "Dia 3: Pernas, Abdômen e Cardio",
                "Pernas: Agachamento 4x12, Leg press 4x12",
                "Abdômen: Abdominais 4x25",
                "Cardio: Esteira ou Bike 20min"
            ],
            5: [
                "Dia 1: Peito e Cardio",
                "Peito: Supino reto 4x10, Flexões 4x12",
                "Cardio: Esteira ou Bike 20min",
                "Dia 2: Costas",
                "Costas: Remada curvada 4x12, Puxada na polia 4x10",
                "Dia 3: Pernas",
                "Pernas: Agachamento 4x12, Leg press 4x12",
                "Dia 4: Ombros e Tríceps",
                "Ombros: Desenvolvimento militar 4x10, Elevação lateral 4x10",
                "Tríceps: Tríceps banco 4x10",
                "Dia 5: Abdômen e Bíceps",
                "Abdômen: Abdominais 4x25",
                "Bíceps: Rosca direta 4x10",
            ]
        },
        avançado: {
            1: [
                "Dia 1:",
                "Peito: Supino reto 5x8, Flexões 5x8",
                "Tríceps: Tríceps banco 5x8",
                "Costas: Puxada na polia 5x8",
                "Bíceps: Rosca direta 5x8 ",
                "Pernas: Agachamento 5x12",
                "Abdômen: Abdominais 4x30",
                "Ombros: Elevação lateral 4x12 ",
                "Cardio: Esteira ou Bike 30min"
            ],
            3: [
                "Dia 1: Peito e Tríceps",
                "Peito: Supino reto 5x8, Flexões 5x8",
                "Tríceps: Tríceps banco 5x8",
                "Dia 2: Costas, Bíceps e Ombros",
                "Costas: Puxada na polia 5x8, Remada curvada 3x12",
                "Bíceps: Rosca direta 5x8 ",
                "Ombros: Elevação lateral 4x12 , Desenvolvimento militar 5x8",
                "Dia 3: Pernas, Abdômen e Cardio",
                "Pernas: Agachamento 5x12, Leg press 5x12",
                "Abdômen: Abdominais 4x30",
                "Cardio: Esteira ou Bike 30min"
            ],
            5: [
                "Dia 1: Peito e Cardio",
                "Peito: Supino reto 5x8, Flexões 5x8",
                "Cardio: Esteira ou Bike 30min",
                "Dia 2: Costas",
                "Costas: Remada curvada 4x12, Puxada na polia 5x8",
                "Dia 3: Pernas",
                "Pernas: Agachamento 5x12, Leg press 5x12",
                "Dia 4: Ombros e Tríceps",
                "Ombros: Desenvolvimento militar 5x8, Elevação lateral 4x12 ",
                "Tríceps: Tríceps banco 5x8",
                "Dia 5: Abdômen e Bíceps",
                "Abdômen: Abdominais 4x30",
                "Bíceps: Rosca direta 5x8 ",
            ]
        }
    }

    // Adicionar log para ver os parâmetros recebidos
    console.log("Parâmetros recebidos:", params);

    // Normalizar as chaves para garantir a correspondência
    const experiencia = params.experiencia.toLowerCase();
    const dias = parseInt(params.dias);

    // Gerar rotina de treino com base nos parâmetros
    if (params.treino === 'Funcional') {
        planoGerado = treinoFuncional[experiencia][dias] || ['Erro: Não foi possível encontrar um treino para esses parâmetros.'];
    } else if (params.treino === 'Cardio') {
        planoGerado = treinoCardio[experiencia][dias] || ['Erro: Não foi possível encontrar um treino para esses parâmetros.'];
    } else if (params.treino === 'Peso Livre') {
        planoGerado = treinoPesoLivre[experiencia][dias] || ['Erro: Não foi possível encontrar um treino para esses parâmetros.'];
    } else {
        planoGerado = ['Tipo de treino não reconhecido.'];
    }

    return planoGerado.join('<br>');
}
