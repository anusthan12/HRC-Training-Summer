import React from 'react';
import './styles.css';
const Table = ({ data }) => {
  return (
    <div class="table-container">
        <table>
      <thead> 
        <tr> 
            <th><input type="checkbox" /></th>
            <th>Sl. No</th> 
            <th>Customer Order id</th> 
            <th>Sales Org</th> 
            <th>Distribution Channel</th> 
            <th>Company Code</th> 
            <th>Order Creating Date</th> 
            <th>Order Amount</th> 
            <th>Order Currency</th> 
            <th>Customer Number</th> 
        </tr> 
      </thead> 
      <tbody>
        {data.map((item, index) => (
          <tr key={index}>
            <td><input type="checkbox" /></td>
            <td>{item.slNo}</td>
            <td>{item.custOrderId}</td>
            <td>{item.salesOrg}</td>
            <td>{item.distChannel}</td>
            <td>{item.comCode}</td>
            <td>{item.orderCreationDate}</td>
            <td>{item.orderAmount}</td>
            <td>{item.orderCurrency}</td>
            <td>{item.custNumber}</td>
          </tr>
        ))}
      </tbody>
    </table>
    </div>
    
  );
};

export default Table;