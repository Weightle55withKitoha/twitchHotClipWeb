import React from "react";
import {
  TableRow,
  TableCell,
  TableBody,
  TableContainer,
  Table,
} from "@material-ui/core";

function LowerTable(props) {
  const rowCells = props.rowCells;
  return (
    <TableContainer>
      <Table aria-label="ranking table">
        <TableBody>
          {rowCells.map((rowCell, index) => (
            <TableRow
              key={rowCell.number}
              style={
                index % 2 ? { background: "#e2e8f0" } : { background: "white" }
              }
            >
              <TableCell>{rowCell.number}</TableCell>
              <TableCell>{rowCell.name}</TableCell>
              <TableCell>{rowCell.rowChatting}</TableCell>
              <TableCell>{rowCell.rowViewer}</TableCell>
              <TableCell>{rowCell.rowFollower}</TableCell>
              <TableCell>{rowCell.rowTime}</TableCell>
              <TableCell>{rowCell.rowEndBroadCasting}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}

export default LowerTable;
