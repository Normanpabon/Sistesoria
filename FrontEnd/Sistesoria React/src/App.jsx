import { BrowserRouter, Route, Routes } from "react-router-dom";
import { useUser } from "./context/UserContext";
import ProtectedRoute from "./components/common/ProtectedRoute";
import Login from "./pages/Login";
import UserMainPage from "./pages/user/UserMainPage";
import ServerDown from "./pages/ServerDown";
import ProfeMainPage from "./pages/profesores/ProfeMainPage";

function App() {
  const { user } = useUser();
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/serverDown" element={<ServerDown />} />
        <Route
          element={
            <ProtectedRoute
              isAllowed={!!user && user.rol === 1}
            />
          }
        >
          <Route path="user" element={<UserMainPage />}>
            
          </Route>
        </Route>
        <Route
          element={
            <ProtectedRoute
              isAllowed={!!user && user.rol === 0}
            />
          }
        >
        
        <Route path="profesor" element={<ProfeMainPage />}>
            
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
