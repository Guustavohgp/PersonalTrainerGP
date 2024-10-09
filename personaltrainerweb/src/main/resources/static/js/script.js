// Função para validar login
async function validarLogin() {
    const usuario = document.getElementById("usuario").value; // Aqui, apenas o campo 'usuario'
    const senha = document.getElementById("senha").value;
    const mensagemLogin = document.getElementById("mensagemLogin");

    if (usuario === "" || senha === "") {
        mensagemLogin.textContent = "Por favor, preencha todos os campos!";
        return false;
    }

    // Fazer requisição para o backend para verificar login
    try {
        const response = await fetch('/api/usuarios/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ usuario: usuario, senha: senha }) // Enviando apenas 'usuario' e 'senha'
        });

        if (response.ok) {
            mensagemLogin.textContent = "Login realizado com sucesso!";
            setTimeout(() => window.location.href = "/home", 1000);
        } else {
            mensagemLogin.textContent = "Usuário ou senha incorretos!";
        }
    } catch (error) {
        mensagemLogin.textContent = "Ocorreu um erro ao fazer login!";
    }

    return false; // Impede o envio imediato do formulário
}

// Função para validar cadastro
async function validarCadastro() {
    const nome = document.getElementById("nome").value; // Campo 'nome'
    const usuario = document.getElementById("usuario").value; // Campo 'usuario'
    const senha = document.getElementById("senha").value; // Campo 'senha'
    const confirmSenha = document.getElementById("confirmSenha").value; // Campo para confirmação de senha
    const mensagemCadastro = document.getElementById("mensagemCadastro");

    if (nome === "" || usuario === "" || senha === "" || confirmSenha === "") {
        mensagemCadastro.textContent = "Por favor, preencha todos os campos!";
        return false;
    }

    if (senha !== confirmSenha) {
        mensagemCadastro.textContent = "As senhas não coincidem!";
        return false;
    }

    const senhaValida = /^(?=.*\d).{6,}$/;
    if (!senhaValida.test(senha)) {
        mensagemCadastro.textContent = "A senha deve ter pelo menos 6 caracteres e conter pelo menos um número!";
        return false;
    }

    try {
        const response = await fetch('/api/usuarios/cadastrar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nome: nome, usuario: usuario, senha: senha }) // Enviando 'nome', 'usuario' e 'senha'
        });

        if (response.ok) {
            mensagemCadastro.textContent = "Cadastro realizado com sucesso!";
            setTimeout(() => window.location.href = "/index", 1000);
        } else {
            const errorMessage = await response.text();
            mensagemCadastro.textContent = `Erro no cadastro: ${errorMessage}`;
        }
    } catch (error) {
        mensagemCadastro.textContent = "Ocorreu um erro ao cadastrar!";
    }

    return false; // Impede o envio imediato do formulário
}

// Funções auxiliares para alternar entre os formulários
function mostrarFormularioCadastro() {
    document.getElementById("cadastroContainer").classList.remove("hidden");
    document.getElementById("loginForm").parentElement.classList.add("hidden");
}

function mostrarFormularioLogin() {
    document.getElementById("cadastroContainer").classList.add("hidden");
    document.getElementById("loginForm").parentElement.classList.remove("hidden");
}