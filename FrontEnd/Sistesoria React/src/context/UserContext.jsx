import { createContext, useContext, useState } from "react";
import axios from "axios";

export const UserContext = createContext();

export const useUser = () => {
  const context = useContext(UserContext);
  return context;
};

export function UserContextProvider({ children }) {
  const [user, setUser] = useState(null);
  const [users, setUsers] = useState([]);
  const sistesoriaRestApi = "http://localhost:8090/V1";
  const [alert, setAlert] = useState(" hidden");
  const [userTitle, setUserTitle] = useState("Asignaturas");


  const formatDate = (fecha) => {
    let formatedDate;
    if (typeof fecha == "object") {
      formatedDate = new Date(`${fecha[0]}/${fecha[1]}/${fecha[2]}`);
    } else {
      formatedDate = new Date(
        `${fecha.slice(0, 4)}/${fecha.slice(5, 7)}/${fecha.slice(8)}`
      );
    }

    return formatedDate;
  };

  const userAuth = async (user, password) => {
    try {
      const { data } = await axios({
        method: "post",
        url: `${sistesoriaRestApi}/usuario/Login/`,
        headers: {},
        data: { usuario: user, password: password },
      });

      //setToken(data.token);
      const userGet = await axios({
        method: "get",
        url: `${sistesoriaRestApi}/usuario/username/${user}`
      });

      console.log(userGet.data)
      const { id, nombre, apellido, rol, codigo_institucional } = userGet.data;

      setUser({
        id: id,
        nombre: nombre,
        apellido: apellido,
        rol: rol,
        cod_ins: codigo_institucional,
      });
      return [rol, true];
    } catch (error) {
      return error;
    }
  };



  return (
    <UserContext.Provider
      value={{
        userAuth: userAuth,
        user: user,
        users: users,
        setUsers: setUsers,
        alert: alert,
        setUser: setUser,
        setAlert: setAlert
      }}
    >
      {children}
    </UserContext.Provider>
  );
}
