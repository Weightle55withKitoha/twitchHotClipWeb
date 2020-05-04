import React, { useState } from "react";
import { TableRow, TableCell, TableHead, Button, Box } from "@material-ui/core";

function UpperTable(props) {
  const headCells = props.headCells;
  const [color, setColor] = useState("dark");
  const colors = [
    "#CCCCFF",
    "#CCCCFF",
    "#CCCCFF",
    "#CCCCFF",
    "#CCCCFF",
    "#CCCCFF",
    "#CCCCFF",
  ];

  const handleMouseHover = (index) => {
    console.log("test1");
    // colors[index] = "#99FF99";
  };

  const hadleMouseLeave = (index) => {
    //colors[index] = "#000000";
  };

  return (
    <TableHead>
      <TableRow>
        {headCells.map((headCell, index) => (
          <TableCell key={headCell.id}>
            <Button
              style={{
                width: "100%",
                height: "100%",
                backgroundColor: colors[index],
              }}
            >
              {headCell.label + index}
            </Button>

            <Box style={{ backgroundColor: "dark" }}></Box>
          </TableCell>
        ))}
      </TableRow>
    </TableHead>
  );
}

export default UpperTable;
