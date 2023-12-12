import React, { useState } from "react";
import styles from "../../styles/login.module.css";
import HeadComponent from "@/components/head";
const Login = () => {
  const [cliente, setCliente] = useState({
    nome: "",
    telefone: "",
    dataNascimento: "",
    cep: "",
    email: "",
    senha: "",
  });
  const handleInputChange = () => {};
  return (
    <>
      <HeadComponent title={"Tropical | Login"} />
      <div className={`${styles.degrade}`}>
        <div className={` container-fluid ${styles.login} text-center`}>
          <div className="row">
            <div className="mb-3 col-5 ">
              <label htmlFor="nome" className="form-label ">
                Nome
              </label>
              <input
                type="text"
                placeholder="Insira seu nome"
                className="form-control text-center "
                id="nome"
                name="nome"
                value={cliente.nome}
                onChange={handleInputChange}
                aria-describedby="emailHelp"
                required=""
              />
            </div>
          </div>
          <div className="row">
            <div className="col-5">
              <label htmlFor="senha" className="form-label ">
                Senha
              </label>
              <input
                type="password"
                placeholder="Insira sua senha"
                className="form-control text-center"
                id="senha"
                name="senha"
                value={cliente.senha}
                onChange={handleInputChange}
                required=""
              />
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
