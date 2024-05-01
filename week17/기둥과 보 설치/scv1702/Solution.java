import java.util.*;

class Solution {
    
    public boolean isPillarUpperToGround(int y) {
        return y == 0;
    }
    
    public boolean isPillarUpperToBeam(int[][] beams, int x, int y) {
        if (y >= beams.length || x >= beams[0].length) {
            return false;
        }
        return (x >= 1 && beams[y][x-1] > 0) || beams[y][x] > 0;
    }
    
    public boolean isPillarUpperToPillar(int[][] pillars, int x, int y) {
        return y >= 1 && pillars[y - 1][x] > 0;
    }
    
    public boolean isBeamConnectedToBeam(int[][] beams, int x, int y) {
        return (x >= 1 && beams[y][x-1] > 0) && 
            (x + 1 < beams[0].length && beams[y][x+1] > 0);
    }
    
    public boolean isBeamUpperToPillar(int[][] pillars, int x, int y) {
        return y >= 1 && pillars[y-1][x] > 0 || (x + 1 < pillars[0].length && pillars[y-1][x+1] > 0);
    }
    
    public boolean validateBeam(int[][] beams, int[][] pillars, int x, int y) {
        return isBeamConnectedToBeam(beams, x, y) || isBeamUpperToPillar(pillars, x, y);
    }
    
    public boolean validatePillar(int[][] beams, int[][] pillars, int x, int y) {
        return isPillarUpperToGround(y) || 
            isPillarUpperToBeam(beams, x, y) || 
            isPillarUpperToPillar(pillars, x, y);
    }
    
    public boolean validateBeams(int[][] beams, int[][] pillars) {
        for (int y = 0; y < beams.length; y++) {
            for (int x = 0; x < beams[0].length; x++) {
                if (beams[y][x] > 0 && !validateBeam(beams, pillars, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validatePillars(int[][] beams, int[][] pillars) {
        for (int y = 0; y < pillars.length; y++) {
            for (int x = 0; x < pillars[0].length; x++) {
                if (pillars[y][x] > 0 && !validatePillar(beams, pillars, x, y)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public List<int[]> solution(int n, int[][] build_frame) {
        List<int[]> answer = new ArrayList<>();
        int[][] pillars = new int[n][n+1]; // pillars[i][j]가 1이면 (i, j)에서 위쪽으로 기둥 존재
        int[][] beams = new int[n+1][n]; // beams[i][j]가 1이면 (i, j)에서 오른쪽으로 보 존재
        
        for (int[] bf : build_frame) {
            int x = bf[0]; // 가로 좌표
            int y = bf[1]; // 세로 좌표
            int a = bf[2]; // 0은 기둥, 1은 보
            int b = bf[3]; // 0은 삭제, 1은 설치
            
            if (a == 0) {
                if (b == 1) {
                    if (validatePillar(beams, pillars, x, y)) {
                        pillars[y][x] = 1;   
                        //System.out.printf("기둥 (%d, %d)에 설치\n", x, y);
                    }
                } else {
                    pillars[y][x] = 0;
                    if (!validatePillars(beams, pillars) || !validateBeams(beams, pillars)) {
                        pillars[y][x] = 1;
                    } else {
                        //System.out.printf("기둥 (%d, %d)에 삭제\n", x, y);
                    }
                }

            } else {
                if (b == 1) {
                    if (validateBeam(beams, pillars, x, y)) {
                        beams[y][x] = 1;
                        //System.out.printf("보 (%d, %d)에 설치\n", x, y);
                    }
                } else {
                    beams[y][x] = 0;
                    if (!validatePillars(beams, pillars) || !validateBeams(beams, pillars)) {
                        beams[y][x] = 1;
                    } else {
                        //System.out.printf("보 (%d, %d)에 삭제\n", x, y);
                    }
                }

            }
        }
        
        for (int y = 0; y < pillars.length; y++) {
            for (int x = 0; x < pillars[0].length; x++) {
                if (pillars[y][x] > 0) {
                    answer.add(new int[] {x, y, 0});
                }
            }
        }
        
        for (int y = 0; y < beams.length; y++) {
            for (int x = 0; x < beams[0].length; x++) {
                if (beams[y][x] > 0) {
                    answer.add(new int[] {x, y, 1});
                }
            }
        }
        
        answer.sort((c1, c2) -> {
            if (c1[0] == c2[0]) {
                if (c1[1] == c2[1]) {
                    return c1[2] - c2[2];
                }
                return c1[1] - c2[1];
            }
            return c1[0] - c2[0];
        });
        
        return answer;
    }
}