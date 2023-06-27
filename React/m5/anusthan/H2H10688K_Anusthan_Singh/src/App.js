import './App.css';
import Table from './components/Table';


function App() {
  const data = [
    { slNo: 1, custOrderId: 754349803, salesOrg: 3911, distChannel: 'United Arab Emirates' , comCode: 3290, orderCreationDate: '01-01-2022', orderAmount: 1405.54, orderCurrency: 'AED' , custNumber: 1210499770  },
    { slNo: 2, custOrderId: 930253442, salesOrg: 2381, distChannel: 'Greece', comCode: 3290, orderCreationDate: '01-01-2022' , orderAmount: 1441.4835, orderCurrency: 'EUR', custNumber: 1210351400},
    { slNo: 3, custOrderId: 819741436, salesOrg: 3605, distChannel: 'Argentina', comCode: 3290, orderCreationDate: '01-01-2022', orderAmount: 1065.33, orderCurrency: 'EUR', custNumber: 1210124309},
    { slNo: 4, custOrderId: 881355361, salesOrg: 3645, distChannel: 'Armenia', comCode: 3470, orderCreationDate: '02-01-2022', orderAmount: 302.85, orderCurrency: 'EUR', custNumber: 1231152},
    { slNo: 5, custOrderId: 821659852, salesOrg: 2470, distChannel: 'United States of America', comCode: 3220, orderCreationDate: '02-01-2022', orderAmount: 8380.69, orderCurrency: 'EUR', custNumber: 1230021722},
    { slNo: 6, custOrderId: 957194828, salesOrg: 3150, distChannel: 'United States Minor Outlying Islands', comCode: 3290, orderCreationDate: '02-01-2022', orderAmount: 545.85, orderCurrency: 'EUR', custNumber: 1210183107},
    { slNo: 7, custOrderId: 806322513, salesOrg: 3396, distChannel: 'Serbia', comCode: 3290, orderCreationDate: '02-01-2022', orderAmount: 545.85, orderCurrency: 'EUR', custNumber: 1210499770},
    { slNo: 8, custOrderId: 922237131, salesOrg: 2353, distChannel: 'Turks andCalcos Islands', comCode: 3290, orderCreationDate: '02-01-2022', orderAmount: 562.73, orderCurrency: 'EUR', custNumber: 1210111951},
  ];

  return (
    <div className="App">
      <header className="App-header">
        <h3>Milestone 5 via H2H10688K_Anusthan_Singh</h3>
        
        <Table data={data} />
        
      </header>
    </div>
  );
}

export default App;
