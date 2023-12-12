import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { useRouter } from 'next/router'
const UpdateReserva = () => {
    const [reserva,setReserva]=useState({id:'',dataReserva:'',dataViagem:"",cliente:{id:""},pacoteDeViagem:{id:""}})

const router=useRouter()
const {codigo}=router.query

useEffect(()=>{
    axios
    .get(`http://localhost:8080/reservas/${reserva.id}`)
    .then((response)=>{
        setReserva(response.data)
    })
    .catch((error )=>{
        console.error("erro ao buscar reserva",error)
    })
},[])
console.log("reserva",reserva)
function handleInputChange(e){
  if(e.target.name=="pacoteDeViagemid"){
    setReserva(reserva.pacoteDeViagem.id=e.target.value)
  }else if(e.target.name=="clienteId"){
    setReserva(reserva.cliente.id=e.target.value)
  }
    setReserva({...reserva,[e.target.name]:e.target.value})
}

console.log("id Pacote",reserva.pacoteDeViagem.id)
console.log("id Cliente",reserva.cliente.id)
function handleUpdateReserva(){
  axios
  .put(`http://localhost:8080/reservas/${reserva.id}`,reserva)
  .then((response)=>{
    router.push("/reserva/lista")
  })
}
  return (
   
    
    <main>
  <h1 >Atualizar Reserva</h1>
  <table style={{marginLeft:'20px'}}>
    <tbody>
      <tr>
        <td>
          <label>ID da reserva:</label>
        </td>
        <td>
          <input
            readOnly
            type="text"
            name="id"
            value={reserva.id=codigo}
            onChange={handleInputChange}
          />
        </td>
      </tr>
      <tr>
        <td>
          <label>Data da reserva:</label>
        </td>
        <td>
          <input
            type="datetime-Local"
            name="dataReserva"
            value={reserva.dataReserva}
            onChange={handleInputChange}
          />
        </td>
      </tr>
      <tr>
        <td>
          <label>Data da viagem:</label>
        </td>
        <td>
          <input
            type="datetime-Local"
            name="dataViagem"
            value={reserva.dataViagem}
            onChange={handleInputChange}
          />
        </td>
      </tr>
      <tr>
        <td>
          <label>Cliente id:</label>
        </td>
        <td>
          <input
            type="text"
            name="clienteId"
            value={reserva.cliente.id}
            onChange={handleInputChange}
          />
        </td>
      </tr>
      <tr>
        <td>
          <label>Pacote id:</label>
        </td>
        <td>
          <input
            type="text"
            name="pacoteDeViagemid"
            value={reserva.pacoteDeViagem.id}
            onChange={handleInputChange}
          />
        </td>
      </tr>
      <tr>
        <td colSpan="2">
          <button className='btn btn-primary' onClick={handleUpdateReserva}>Atualizar Pacote</button>
        </td>
      </tr>
    </tbody>
  </table>
</main>

  )
}

export default UpdateReserva