import React from "react";
import {
  TableRow,
  TableCell,
  TableBody,
  TableContainer,
  Table,
  Typography,
} from "@material-ui/core";

function LowerTable(props) {
  const rowCells = props.rowCells;
  let table;

  if (rowCells != null) {
    table = (
      <TableBody>
        {rowCells.map((rowCell, index) => (
          <TableRow
            key={rowCell.streamerName}
            style={
              index % 2 ? { background: "#e2e8f0" } : { background: "white" }
            }
          >
            <TableCell>{index + 1}</TableCell>
            <TableCell>{rowCell.streamerName}</TableCell>
            <TableCell>{rowCell.viewerCount}</TableCell>
            <TableCell>{rowCell.followerCount}</TableCell>
            <TableCell>{rowCell.viewerAverage}</TableCell>
            <TableCell>{rowCell.broadcastTime}</TableCell>
            <TableCell>{rowCell.broadcastEndTime}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    );
  } else {
    table = (
      <TableBody>
        <TableRow>
          <TableCell>
            <Typography>로그인이 필요합니다.</Typography>
          </TableCell>
        </TableRow>
      </TableBody>
    );
  }
  return (
    <TableContainer>
      <Table aria-label="ranking table">{table}</Table>
    </TableContainer>
  );
}

export default LowerTable;
