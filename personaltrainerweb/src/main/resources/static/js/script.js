function validarLogin() {
    const loginUsername = document.getElementById("loginUsername").value;
    const loginPassword = document.getElementById("loginPassword").value;
    const mensagemLogin = document.getElementById("mensagemLogin");

    if (loginUsername === "" || loginPassword === "") {
        mensagemLogin.textContent = "Por favor, preencha todos os campos!";
        return false;
    }

    mensagemLogin.textContent = "Login realizado com sucesso!";
    return true;
}

function validarCadastro() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirmPassword").value;
    const mensagemCadastro = document.getElementById("mensagemCadastro");

    if (password !== confirmPassword) {
        mensagemCadastro.textContent = "As senhas não coincidem!";
        return false;
    }

    if (password.length < 6) {
        mensagemCadastro.textContent = "A senha deve ter pelo menos 6 caracteres!";
        return false;
    }

    mensagemCadastro.textContent = "Cadastro realizado com sucesso!";
    return true;
}

function mostrarFormularioCadastro() {
    document.getElementById("cadastroContainer").classList.remove("hidden");
    document.getElementById("loginForm").parentElement.classList.add("hidden");
}

function mostrarFormularioLogin() {
    document.getElementById("cadastroContainer").classList.add("hidden");
    document.getElementById("loginForm").parentElement.classList.remove("hidden");
}