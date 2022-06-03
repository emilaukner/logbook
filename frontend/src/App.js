import './App.css';
import Home from './containers/Home';
import About from './containers/About';
import Workouts from './containers/Workouts';
import CreateWorkoutPage from './containers/CreateWorkoutPage';
import SingleWorkoutPage from './containers/SingleWorkoutPage';
import NavBar from './components/NavBar';
import  {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";


function App() {
  return (
    <div className="App">
        <div className="content">
          <Router>
            <NavBar/>
            <div>
              <Routes>
                <Route path="/about/" element={<About />} />
                <Route path="/workouts/" element={<Workouts />} />
                <Route path="/workouts/:id" element={<SingleWorkoutPage />}/>
                <Route path='/create-workout/' element={<CreateWorkoutPage />} />
                <Route path="/" element={<Home />} />
              </Routes>
            </div>
          </Router>
      </div>
    </div>
  );
}

export default App;
