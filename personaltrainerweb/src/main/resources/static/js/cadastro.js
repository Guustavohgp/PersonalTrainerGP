document.getElementById("cadastroForm").addEventListener("submit", function (event) {
    event.preventDefault();

    // Captura os dados do formulário
    const nome = document.getElementById("nome").value.trim();
    const usuario = document.getElementById("usuario").value.trim();
    const senha = document.getElementById("senha").value.trim();
    const mensagemCadastro = document.getElementById("mensagemCadastro");

    // Validações simples
    if (!nome || !usuario || !senha) {
        mensagemCadastro.textContent = "Por favor, preencha todos os campos!";
        mensagemCadastro.classList.add("erro");
        return;
    }

    // Cria um objeto com os dados do formulário
    const usuarioCadastro = {
        nome: nome,
        usuario: usuario,
        senha: senha
    };

    // Envia uma requisição POST para o backend
    fetch("/cadastrar", {  
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuarioCadastro)
    })
    .then(response => {
        if (response.ok) {
            return response.json(); // Supondo que a resposta do servidor seja JSON
        } else {
            // Tratar resposta com erro de usuário já existente
            return response.json().then(err => {
                throw new Error(err.message || "Erro ao cadastrar o usuário");
            });
        }
    })
    .then(data => {
        // Exibe mensagem de sucesso
        mensagemCadastro.textContent = "Usuário cadastrado com sucesso!";
        mensagemCadastro.classList.remove("erro");

        // Redireciona para outra página 
        setTimeout(() => {
            window.location.href = "/index";
        }, 1000);
    })
    .catch(error => {
        mensagemCadastro.textContent = error.message;
        mensagemCadastro.classList.add("erro");
    });
});