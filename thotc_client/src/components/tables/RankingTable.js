import React from "react";
import { Paper, TableContainer, Table, Container } from "@material-ui/core";
import TableHead from "./UpperTable";
import TableLower from "./LowerTable";
import TableToolbar from "./TableToolbar";

const headCells = [
  { id: "rank", label: "순위", color: "yellow" },
  { id: "streamer", label: "스트리머", color: "yellow" },
  { id: "chatting", label: "실시간채팅", color: "yellow" },
  { id: "viewer", label: "시청자", color: "yellow" },
  { id: "follower", label: "팔로워", color: "yellow" },
  { id: "time", label: "방송시간", color: "yellow" },
  { id: "endBroadCasting", label: "마지막방송", color: "yellow" },
];

function createData(
  number,
  name,
  rowChatting,
  rowViewer,
  rowFollower,
  rowTime,
  rowEndBroadCasting
) {
  return {
    number,
    name,
    rowChatting,
    rowViewer,
    rowFollower,
    rowTime,
    rowEndBroadCasting,
  };
}

const rows = [
  createData(1, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(2, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(3, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(4, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(5, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(6, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(7, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(8, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(9, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
  createData(10, "선바", "4.8개", "3,739", "214,635", "주 35시간", "지금"),
];

const rankingTable = () => {
  return (
    <Container style={{ marginTop: 50 }} maxWidth="lg">
      <Paper>
        <TableToolbar></TableToolbar>
        <TableContainer>
          <Table aria-label="ranking table">
            <TableHead headCells={headCells}></TableHead>
            <TableLower rowCells={rows}></TableLower>
          </Table>
        </TableContainer>
      </Paper>
    </Container>
  );
};

export default rankingTable;
