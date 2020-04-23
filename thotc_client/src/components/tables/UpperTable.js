import React, { useState } from "react";
import { TableRow, TableCell, TableHead } from "@material-ui/core";

function UpperTable(props) {
  const headCells = props.headCells;
  const [color, setColor] = useState("dark");

  const handleMouseHover = () => {
    console.log("test");
    setColor("blue");
  };

  const hadleMouseLeave = () => {
    setColor("white");
  };

  return (
    <TableHead>
      <TableRow hover>
        {headCells.map((headCell) => (
          <TableCell
            onMouseEnter={handleMouseHover}
            onMouseLeave={hadleMouseLeave}
            style={{ backgroundColor: color }}
            key={headCell.id}
          >
            {headCell.label}
          </TableCell>
        ))}
      </TableRow>
    </TableHead>
  );
}

export default UpperTable;
