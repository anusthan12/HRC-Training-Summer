import React, { useState, useEffect } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { makeStyles } from '@mui/styles';
import { orange } from '@mui/material/colors';
import axios from 'axios';

const useStyles = makeStyles(() => ({
  container: {
    display: 'flex',
    justifyContent: 'center',
  },
  tableContainer: {
    backgroundColor: 'gray',
    '& .MuiDataGrid-cell': {
      color: 'white',
    },
    '& .MuiDataGrid-columnHeader, .MuiDataGrid-footerContainer': {
      color: 'white',
    },
    '& .MuiDataGrid-virtualScroller::-webkit-scrollbar': {
      width: '8px',
      height: '12px',
    },
    '& .MuiDataGrid-virtualScroller::-webkit-scrollbar-track': {
      background: 'gray',
    },
    '& .MuiDataGrid-virtualScroller::-webkit-scrollbar-thumb': {
      backgroundColor: '#555',
      borderRadius: '8px',
    },
    '& .MuiDataGrid-virtualScroller::-webkit-scrollbar-thumb:hover': {
      background: '#555',
    },
    '& .MuiDataGrid-checkboxInput.Mui-checked': {
      color: orange[500],
    },
    '& .MuiDataGrid-cellCheckbox .MuiDataGrid-checkboxInput': {
      color: orange[500],
    },
    '& .MuiDataGrid-columnHeaderCheckbox .MuiDataGrid-checkboxInput': {
      color: orange[500],
    },
    maxWidth: 1200,
    border: '9px solid orange',
  },
}));

const columns = [
  { field: 'id', headerName: 'ID', width: 90 },
  { field: 'customerOrderID', headerName: 'Customer Order ID', width: 200 },
  { field: 'salesOrg', headerName: 'Sales Org', width: 150 },
  { field: 'distributionChannel', headerName: 'Distribution Channel', width: 200 },
  { field: 'companyCode', headerName: 'Company Code', width: 150 },
  { field: 'orderCreationDate', headerName: 'Order Creation Date', width: 200 },
  { field: 'orderAmount', headerName: 'Order Amount', width: 150 },
  { field: 'orderCurrency', headerName: 'Order Currency', width: 150 },
  { field: 'customerNumber', headerName: 'Customer Number', width: 200 },
  { field: 'amountInUSD', headerName: 'Amount in USD', width: 150 },
];

const generateRowsWithIds = (rows) => {
  return rows.map((row, index) => ({ id: index + 1, ...row }));
};

const App = () => {
  const [data, setData] = useState([]);

  const fetchDataFromServlet = async () => {
    try {
      const response = await axios.get('http://localhost:9000/hrc_milestone_3/data');
      return response.data;
    } catch (error) {
      console.error('Error fetching data from servlet:', error);
      return [];
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      const responseData = await fetchDataFromServlet();
      const rowsWithIds = generateRowsWithIds(responseData);
      setData(rowsWithIds);
    };

    fetchData();
  }, []);

  const classes = useStyles();

  return (
    <div className={classes.container}>
      <div className={classes.tableContainer}>
        <DataGrid
          {...data}
          initialState={{
            ...data.initialState,
            pagination: { paginationModel: { pageSize: 8 } },
          }}
          pageSizeOptions={[8, 10, 25]}
          rows={data}
          columns={columns}
          checkboxSelection
          autoHeight
          disableSelectionOnClick

        />
      </div>
    </div>
  );
};

export default App;
